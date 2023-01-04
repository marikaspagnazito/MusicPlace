package it.model;

import java.io.Serializable;
import java.util.Calendar;

public class OrdineBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int numeroOrdine;
	private String username;
	private Calendar data;
	private double prezzo;
	private double IVA;
	private String numeroCarta;
	
	
	
	public int getNumeroOrdine() {
		return numeroOrdine;
	}
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	
	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public void setData(Calendar data) {
		this.data = (Calendar) data.clone();
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo=prezzo;
	}
	public double getIVA() {
		return IVA;
	}
	public void setIVA(double iVA) {
		IVA = iVA;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	
}
