package poo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show extends Evenement implements Searchable {

	private double price;
	private ArrayList<Artist> artists;

	public Show(String texte, LocalDateTime localDateTime, double price, ArrayList<Artist> artists) {
		super(texte, localDateTime);
		this.price = price;
		this.artists = artists;
	}
	



	public Show(String texte, LocalDateTime localDateTime, double price) {
		super(texte, localDateTime);
		this.price = price;
	}
	




	public Show(String texte, LocalDateTime localDateTime) {
		super(texte, localDateTime);
	}




	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<Artist> getArtists() {
		return artists;
	}

	public void setAtists(ArrayList<Artist> atists) {
		this.artists = atists;
	}

	@Override
	public String toString() {
		return "Show [price=" + price + ", atists=" + artists + "]";
	}

	@Override
	public List<String> findBy(String s) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
