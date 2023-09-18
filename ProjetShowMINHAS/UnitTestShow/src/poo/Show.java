package poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un évènement de type Show.
 * Un Show est un type d'événement spécifique avec des artistes et un prix.
 * Il étend la classe Evenement.
 * 
 * @author M. Minhas
 * @version 1.0
 * 
 */

public class Show extends Evenement implements Searchable {
	/**
	 * Le prix du spectacle.
	 */
	private double price;
	/**
	 * La liste des artistes participant au spectacle.
	 */
	private ArrayList<Artist> artistes;

	/**
	 * Obtient le prix du spectacle.
	 * 
	 * @return Le prix du spectacle.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Définit le prix du spectacle.
	 * 
	 * @param price Le prix du spectacle.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Obtient la liste des artistes participant au spectacle.
	 * 
	 * @return La liste des artistes.
	 */
	public ArrayList<Artist> getArtistes() {
		return artistes;
	}
	/**
	 * Définit la liste des artistes participant au spectacle.
	 * 
	 * @param artistes La liste des artistes.
	 */
	public void setArtistes(ArrayList<Artist> artistes) {
		this.artistes = artistes;
	}
	/**
	 * Constructeur pour un spectacle avec tous les détails.
	 * 
	 * @param texte     Le titre du spectacle.
	 * @param dateEvent La date du spectacle.
	 * @param price     Le prix du spectacle.
	 * @param artistes  La liste des artistes participant au spectacle.
	 */
	public Show(String texte, LocalDate dateEvent, double price, ArrayList<Artist> artistes) {
		super(texte, dateEvent);
		this.price = price;
		this.artistes = artistes;
	}



	public Show(String string, String string2, double d) {
		super(string2, LocalDate.now());
		this.price = d;
		this.artistes = new ArrayList<>();
	}

	public Show(String string, LocalDate sundayDate, String string2) {
		super(string, sundayDate);
		
	}
	/**
	 * Recherche des informations dans le spectacle.
	 * 
	 * @param string La chaîne de caractères à rechercher.
	 * @return Une liste de résultats correspondants.
	 */
	@Override
	public List<String> findBy(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Retourne une représentation sous forme de chaîne de caractères de l'objet Show.
	 * 
	 * @return Une chaîne de caractères représentant l'objet Show.
	 */
	@Override
	public String toString() {
		return "Show [price=" + price + ", artistes=" + artistes + "]";
	}
	public List<String> getArtists() {
		// TODO Auto-generated method stub
		return null;
	}
	
	   public Show(String title, LocalDate date, double price) {
	        super(title, date);
	        this.price = price;
	        this.artistes = new ArrayList<>();
	   }
	   /**Show gratuit
	    * 
	    * @param title
	    * @param date
	    */
	   
	   public Show(String title, LocalDate date ) {
	        super(title, date);
	        this.price = 0;
	        this.artistes = new ArrayList<>();
	   }
	   
	   
	   
	        
	        
	
	
	
	
	
	
	
	

}
