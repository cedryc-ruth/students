package poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Show extends Evenement implements Searchable {
	
	private double price;
	ArrayList<Artist> artist;
	
	
	
	

	public Show(String string, String string2) {
		super();
		this.price = double;
		this.artist = string2;
	}

	}
	public  Show(String string, String string2, double d) {
		// TODO Auto-generated constructor stub
	}
	public void Show(String string, String string2, double d) {
		// TODO Auto-generated constructor stub
	}
	public void Show2 (String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<Artist> getArtist() {
		return artist;
	}
	public void setArtist(ArrayList<Artist> artist) {
		this.artist = artist;
	}
	
	
	@Override
	public List findBy(String s) {
		return null;
	}
	@Override
	public String toString() {
		return "Show [price=" + price + ", artist=" + artist + "]";
	}
	
	
	
	
	
	
	
	
	

}
