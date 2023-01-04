package it.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import it.model.AlbumBean;
import it.model.AlbumModelDM;
import it.model.BranoBean;
import it.model.BranoModelDM;
import it.model.Cart;
import it.model.OrdineBean;
import it.model.OrdineDettaglioBean;
import it.model.OrdineDettaglioModelDM;
import it.model.OrdineModelDM;
import it.model.PagamentoBean;
import it.model.PagamentoModelDM;
import it.model.UtenteBean;
import it.model.UtenteModelDM;

@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MakeOrder() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
       if (request.getSession().getAttribute("currentUser") != null) {

			// prendo l'username dell'utente loggato

			String username = (String) request.getSession().getAttribute("currentUser");

			// prendo i prodotti dal carrello
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			List<Object> prodotti = (ArrayList<Object>) cart.getItems();
			Double total = cart.getPrezzoTotale();

			// controllo se nel carrello ci sono elementi nella libreria
			OrdineModelDM model = new OrdineModelDM();
			OrdineDettaglioModelDM modelD = new OrdineDettaglioModelDM();
			AlbumModelDM modelA = new AlbumModelDM();
			BranoModelDM modelB = new BranoModelDM();
			boolean flag = true;
			String valori = " ";

			try {
				Collection<OrdineBean> ordini = (Collection<OrdineBean>) model.doRetrieveByUsername(username);

				for (OrdineBean ordine : ordini) {
					int order = ordine.getNumeroOrdine();
					Collection<OrdineDettaglioBean> dettagli = (Collection<OrdineDettaglioBean>) modelD.doRetrieveAllByOrder(order);
					for (OrdineDettaglioBean dettaglio : dettagli) {
						int idalbum = dettaglio.getIdAlbum();
						int idbrano = dettaglio.getIdBrano();

						if (idalbum != 0) {
							for (Object i : prodotti) {
								if (i instanceof AlbumBean) {
									AlbumBean album = new AlbumBean();
									album = (AlbumBean) i;
									if (album.getID() == idalbum) {
										flag = false;
										valori += album.getTitolo() + " , ";
									}
								}else {
									BranoBean brano= new BranoBean();
									brano= (BranoBean) i;
									if(brano.getIdAlbum()==idalbum) {
										flag=false;
										valori+= brano.getTitolo() + ",";
									}
								}
							}
						} else {
							for (Object i : prodotti) {
								if (i instanceof BranoBean) {
									BranoBean brano = new BranoBean();
									brano = (BranoBean) i;
									if (brano.getID() == idbrano) {
										flag = false;
										valori += brano.getTitolo() + " , ";
									}
								}
							}
						}
					}
				}
				
				
			//se c'è almeno un elemento comunico l'errore
			if(flag==false) {
				request.setAttribute("messaggio", valori);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CarrelloView.jsp");
				dispatcher.forward(request, response);
				
			
			}//se non c'è nulla procedo con l'ordine
			else {
				
			// prendo gli elementi del form sul pagamento e li memorizzo
			PagamentoBean pagamento = new PagamentoBean();
			PagamentoModelDM modelP = new PagamentoModelDM();
			String numeroCarta = request.getParameter("numero");
			pagamento.setNumeroCarta(numeroCarta);
			String titolare = request.getParameter("titolare");
			pagamento.setTitolare(titolare);
			String circuito = request.getParameter("circuito");
			pagamento.setCircuito(circuito);
			String data = request.getParameter("scadenza");
			pagamento.setData(data);
			String cvv = request.getParameter("cvv");
			pagamento.setCvv(cvv);

			// controllo se la carta già c'è
			try {
				PagamentoBean bean= new PagamentoBean();
				bean=modelP.doRetrieveByKey(numeroCarta);
				if (!pagamento.equals(bean) || bean==null) {
					modelP.doSave(pagamento, username);
				}

			} catch (SQLException e4) {
				e4.printStackTrace();
			}

			// creo l'ordine
			OrdineBean ordine = new OrdineBean();

			// creo id dell'ordine
			int id = 0;

			try {
				id = model.nextId();
				ordine.setNumeroOrdine(id);
			} catch (SQLException e2) {
				System.out.println(e2);
			}
			ordine.setUserName(username);
			Calendar date = Calendar.getInstance();
			ordine.setData(date);
			ordine.setPrezzo(total);
			ordine.setIVA( Math.round((total * 22 / 100)*100.0)/100.0);
			ordine.setNumeroCarta(numeroCarta);

			try {
				model.doSave(ordine);
			} catch (SQLException e1) {
				System.out.println(e1);
			}

			// Creo i riferimenti ordini per i prodotti
			OrdineDettaglioBean dettaglio = null;

			for (Object e : prodotti) {
				if (e instanceof AlbumBean) {
					dettaglio = new OrdineDettaglioBean();
					AlbumBean album = new AlbumBean();
					album = (AlbumBean) e;
					dettaglio.setIdOrdine(id); // funziona?
					dettaglio.setTitolo(album.getTitolo());
					dettaglio.setIVA(album.getIVA());
					dettaglio.setPrezzo(album.getPrezzo());
					dettaglio.setIdAlbum(album.getID());
				} else if (e instanceof BranoBean) {
					dettaglio = new OrdineDettaglioBean();
					BranoBean brano = new BranoBean();
					brano = (BranoBean) e;
					dettaglio.setIdOrdine(ordine.getNumeroOrdine());
					dettaglio.setTitolo(brano.getTitolo());
					dettaglio.setIVA(brano.getIVA());
					dettaglio.setPrezzo(brano.getPrezzo());
					dettaglio.setIdBrano(brano.getID());
				}

				try {
					modelD.doSave(dettaglio);
				} catch (SQLException e3) {
					System.out.println(e3);
				}

			}

			
			
			request.getSession().removeAttribute("cart");
			request.getSession().setAttribute("messaggio", "L'ordine è avvenuto con successo");
			RequestDispatcher req = (RequestDispatcher) request.getRequestDispatcher("HomeView.jsp");
			req.forward(request, response);
				
				
			}
					
			} catch (SQLException e) {
				e.printStackTrace();

				request.setAttribute("error", e.getMessage());
			}


		} else {
			RequestDispatcher req = (RequestDispatcher) request.getRequestDispatcher("LoginView.jsp");
			req.forward(request, response);
		}
	}

}