package it.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<Object> items;

	public Cart() {
		items = new ArrayList<Object>();

	}

	public List<Object> getItems() {
		return items;
	}

	public void deleteItems() {
		items.clear();
	}

	public int count() {
		return items.size();
	}

	public boolean isInCart(Object item) {
		boolean flag = false;

		for (Object e : items) {
			if (e.equals(item)) {
				flag = true;
			} else {
				flag = false;
			}

		}
		return flag;

	}
	


	public int getItemID(Object item) {
		if (item instanceof AlbumBean) {
			AlbumBean album = new AlbumBean();
			return album.getID();
		} else {
			BranoBean brano = new BranoBean();
			return brano.getID();
		}
	}

	public void addItem(Object item) {

		if (!items.contains(item)) {
			items.add(item);
		}

	}

	public void deleteItem(Object item) {
		items.remove(item);

	}

	public double getPrezzoTotale() {
		double totale = 0;

		for (Object e : items) {
			if (e instanceof AlbumBean) {
				AlbumBean album = new AlbumBean();
				album = (AlbumBean) e;
				totale += album.getPrezzo();
			} else {
				BranoBean brano = new BranoBean();
				brano = (BranoBean) e;
				totale += brano.getPrezzo();
			}
		}
		return totale;
	}

	
}