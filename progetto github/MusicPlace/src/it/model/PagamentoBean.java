package it.model;

import java.io.Serializable;
import java.util.Calendar;

public class PagamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numeroCarta;
	private String titolare;
	private String circuito;
	private String data;
	private String cvv;
	
	
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public String getCircuito() {
		return circuito;
	}
	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	public String getTitolare() {
		return titolare;
	}
	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
        
}
