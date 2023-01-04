package it.model;
import java.io.Serializable;


public class AlbumBean implements Serializable {
	private static final long serialVersionUID = 1L;

	int ID;
	String artista;
	String titolo;
	String casa_discografica;
	double prezzo;
	double IVA;
	int anno_produzione;
	String copertina;
	
	
	public AlbumBean() {
		titolo = "";
		casa_discografica = "";
		prezzo = 0;
		IVA = 0;
	}
	
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getCopertina() {
		return copertina;
	}

	public void setCopertina(String copertina) {
		this.copertina = copertina;
	}

	

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCasa_discografica() {
		return casa_discografica;
	}

	public void setCasa_discografica(String casa_discografica) {
		this.casa_discografica = casa_discografica;
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

	public void setIVA(double IVA) {
		this.IVA = IVA;
	}
	
	public int getAnnoProduzione() {
		return anno_produzione;
	}
	
	public void setAnnoProduzione(int anno_produzione) {
		this.anno_produzione=anno_produzione;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumBean other = (AlbumBean) obj;
		if (ID != other.ID)
			return false;
		if (Double.doubleToLongBits(IVA) != Double.doubleToLongBits(other.IVA))
			return false;
		if (anno_produzione != other.anno_produzione)
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (casa_discografica == null) {
			if (other.casa_discografica != null)
				return false;
		} else if (!casa_discografica.equals(other.casa_discografica))
			return false;
		if (copertina == null) {
			if (other.copertina != null)
				return false;
		} else if (!copertina.equals(other.copertina))
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
		return "AlbumBean [ID=" + ID + ", artista=" + artista + ", titolo=" + titolo + ", casa_discografica="
				+ casa_discografica + ", prezzo=" + prezzo + ", IVA=" + IVA + ", anno_produzione=" + anno_produzione
				+ ", copertina=" + copertina + "]";
	}
	
	
}
