<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, it.model.*, it.control.*, java.lang.*, java.io.*"%>

<%
Cart carrello = (Cart) request.getSession().getAttribute("cart");

String messaggio= (String) request.getAttribute("messaggio");


%>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" type= "text/css" href="css/CarrelloCSS.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
<style >
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px; 
}
</style>
<title>Carrello</title>
</head>
<body>

<%
	String username = (String) request.getSession().getAttribute("currentUser");

	if (username == null || username.equals("")) {
	%>
	
	<%@include file="../fragments/navbar.jsp"%>
	
	<%
	
	} else {
	%>
	
	<%@include file="../fragments/navbarLog.jsp"%>
	
	<%
	}
	%>


	<%
	if (carrello == null || carrello.count()==0) {
	%>
	     
	    <div class="container mt-3" style="padding-top:150px;">
            <div class="d-flex justify-content-center mb-3"  >
			<img class="logo" src="img/carrellovuoto.png" alt="Carrello Vuoto"  width="543" height="466" ></img>
			</div>
			 </div>
	   
	   
	

	<%
	} else {
		
		if(messaggio!=null){
			%>	
			<div class= "container" style="padding-top: 100px">
			<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>ERRORE!</strong> Gli elementi : <%=messaggio%> sono già presenti nella libreria
  </div> </div>
	
	<%			
		}
			
	%>

 <h3>CARRELLO</h3>
	 <div class="container">
	 <div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	 <div class="table-responsive-xl" align="center" >
	 <table class="table table-hover table-bordered">
	 <thead class="thead-dark">
		<tr>
		    <th scope="col">Copertina</th>
		    <th scope="col">Titolo</th>
			<th scope="col">Prezzo</th>
			<th scope="col">Di cui IVA</th>
			<th scope="col"> </th>
		</thead>
		<tbody>
		</tr>

		<%
		List<Object> elementi = new ArrayList();
		elementi = carrello.getItems();

		for (Object e : elementi) {
			if (e instanceof AlbumBean) {
				AlbumBean album = new AlbumBean();
				album = (AlbumBean) e;
		%>
<tr>
			<th scope="row"> <img alt="Not found" src="<%=album.getCopertina()%>" width="100" height="100"></th>
			<td><%=album.getTitolo()%></td>
			<td><%=album.getPrezzo()%></td>
			<td><%=album.getIVA()%></td>
		    <td><a
			href="CarrelloControl?action=delete&product=<%=album.getID()%>&type=album">Cancella
				elemento</a></td>
		</tr>

		<%
		} else {
		BranoBean brano = new BranoBean();
		AlbumBean album= new AlbumBean();
		AlbumModelDM model= new AlbumModelDM();
		brano = (BranoBean) e;
		String id= String.valueOf(brano.getIdAlbum());
		album= model.doRetrieveByKey(id);
		%>
		<tr>
			<th scope="row"><img alt="Not found" src="<%=album.getCopertina()%>" width="100" height="100"></th>
			<td><%=brano.getTitolo()%></td>
			<td><%=brano.getPrezzo()%></td>
			<td><%=brano.getIVA()%></td>
			<td>
			<a
			href="CarrelloControl?action=delete&product=<%=brano.getID()%>&type=brano">Cancella
				elemento</a></td>
		</tr>
		<%
		}
		}
		%>
		</tbody>
</table></div></div></div>


<h3>PAGAMENTI  </h3>
	<div class="container">
<form action="MakeOrder" method="post"  onsubmit="event.preventDefault(); pagamentiControl(this);" 
    onchange="validationChange();"  novalidate>
<input type="hidden" name="action" value="pagamenti"> 
<div class="row justify-content-center">
        <div class="col-lg-12">
            <div class="card">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="row px-2">
                            <div class="form-group col-md-12"> <label  for="numero"> Numero Carta</label> <input type="text" style="background-color: #F3E5F5;" class="form-control" name="numero" placeholder="1111 2222 3333 4444" id="numero" required> 
                            <div class="invalid-feedback" id="errorn">il formato non è corretto</div>
						    <div class="valid-feedback" id="errorName">Corretto</div>
						</div>
                            <div class="form-group col-md-6"> <label  for="titolare">Titolare</label> <input type="text" style="background-color: #F3E5F5;" class="form-control" name="titolare" placeholder="Johnny Doe" id="titolare" required >
                            <div class="invalid-feedback" id="errort">il formato non è corretto</div>
						    <div class="valid-feedback" id="errorName">Corretto</div>
						</div>
                             <div class="form-group col-md-6"><label  for="circuito">Circuito</label><input type="text" style="background-color: #F3E5F5;" class="form-control"  name="circuito" placeholder="Visa ecc..." id="circuito" required>
                             <div class="invalid-feedback" id="errorc">il formato non è corretto</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
						</div>
                        </div>
                        <div class="row px-2">
                            <div class="form-group col-md-6"> <label  for="scadenza">Data Scadenza</label> <input type="text" style="background-color: #F3E5F5;" class="form-control"  name="scadenza" placeholder="MM/YYYY" id="scadenza" required>
                            <div class="invalid-feedback" id="errorn">il formato non correto o scadenza non valida</div>
						<div class="valid-feedback" id="errorName">Corretto</div> </div>
                            <div class="form-group col-md-6"> <label class="form-control-label" for="cvv">CVV</label> <input type="password" style="background-color: #F3E5F5;" class="form-control" name="cvv" placeholder="***" maxlength="3" id="cvv" required>
                            <div class="invalid-feedback" id="errorcvv">il cvv deve essere minimo 3 numeri</div>
						<div class="valid-feedback" id="errorName">Corretto</div> </div>
                        </div>
                    </div>
                    <div class="col-lg-4 mt-2">
                        <div class="row d-flex justify-content-between px-4">
                            <p class="mb-1 text-left">Totale carrello</p>
                            <h6 class="mb-1 text-right">€<%=carrello.getPrezzoTotale()%></h6>
                        </div>
                        <div class="row d-flex justify-content-between px-4">
                            <p class="mb-1 text-left">di cui IVA</p>
                            <h6 class="mb-1 text-right">€ <%= Math.round((carrello.getPrezzoTotale() * 22 / 100)*100.0)/100.0%></h6>
                        </div>
                        <div class="row d-flex justify-content-between px-4" id="tax">
                            <p class="mb-1 text-left">Totale</p>
                            <h6 class="mb-1 text-right">€<%=carrello.getPrezzoTotale()%></h6>
                        </div> <button class="btn-block btn-blue"> <span> <span id="checkout">Checkout</span> <span id="check-amt">€<%=carrello.getPrezzoTotale()%></span> </span> </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</div>
	<%
	}
	%>


            <div id="footer">
			<%@include file="../fragments/footer.jsp"%>
		    </div>
		    
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="scripts/pagamenti.js?3"></script>		    
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</body>
</html>