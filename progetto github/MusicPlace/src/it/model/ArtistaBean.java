package it.model;

import java.io.Serializable;

public class ArtistaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int ID;
	String nome;
	String foto;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
