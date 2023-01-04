package it.model;

import java.io.Serializable;

public class BranoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int ID;
	String titolo;
	double prezzo;
	double IVA;
	int IDAlbum;
	
	public BranoBean() {
		ID = 0;
		titolo = "";
		prezzo = 0.0;
		IVA = 0.0;
		IDAlbum=0;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
		return IDAlbum;
	}

	public void setIdAlbum(int ID) {
		IDAlbum=ID;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BranoBean other = (BranoBean) obj;
		if (ID != other.ID)
			return false;
		if (IDAlbum != other.IDAlbum)
			return false;
		if (Double.doubleToLongBits(IVA) != Double.doubleToLongBits(other.IVA))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BranoBean [ID=" + ID + ", titolo=" + titolo + ", prezzo=" + prezzo + ", IVA=" + IVA + ", IDAlbum="
				+ IDAlbum + "]";
	}
	
	
}
