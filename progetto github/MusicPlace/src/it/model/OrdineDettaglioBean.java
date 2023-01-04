package it.model;

import java.io.Serializable;

public class OrdineDettaglioBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idOrdine;
	private String titolo;
	private double prezzo;
	private double IVA;
	private int idAlbum;
	private int idBrano;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public double getIVA() {
		return IVA;
	}
	public void setIVA(double iVA) {
		IVA = iVA;
	}
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public int getIdBrano() {
		return idBrano;
	}
	public void setIdBrano(int idBrano) {
		this.idBrano = idBrano;
	}
	
	

}
