package it.model;

import java.sql.Date;
import java.util.Calendar;

public class UtenteBean{
	private String username;
	private String password;
	private String email;
	private String nome;
	private String cognome;
	private Calendar data_nascita;
	private String citta;
	private String provincia;
	private String cap;
	private String indirizzo;
	private String civico;
	private String contatto;
	
	public UtenteBean() {
		username = " ";
		password = " ";
		email = " ";
		nome = " ";
		cognome = " ";
		data_nascita=null;
		citta = " ";
		provincia = " ";
		cap = " ";
		indirizzo = " ";
		civico = " ";
		contatto = " ";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Calendar getData_nascita() {
		return data_nascita;
	}
	public void setData_nascita(Calendar calendar) {
		this.data_nascita = calendar;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getContatto() {
		return contatto;
	}
	public void setContatto(String contatto) {
		this.contatto = contatto;
	}
		
}
