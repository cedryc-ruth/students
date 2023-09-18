package examen;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * represente un show
 * 
 * @author Amyai Zakariya
 * @since 04/09-2023
 * @version 0.1
 */

public class Show extends Evenement implements Searchable {
	/** le prix des billets
	 * 
	 */
	public Double price;
	/** 
	 * la liste des  artistes
	 */
	
	 
	private ArrayList <Artist> artistes ;
	/**
	 * le nom du show
	 
	 * @return
	 */
	private String nom
	/**
	 * la date de l'évenement
	 * 
	 * @return
	 */
	private LocalDateTime DateEvent
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDateTime getDateEvent() {
		return DateEvent;
	}
	public void setDateEvent(LocalDateTime dateEvent) {
		DateEvent = dateEvent;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ArrayList<Artist> getArtistes() {
		return artistes;
	}
	public void setArtistes(ArrayList<Artist> artistes) {
		this.artistes = artistes;
	}
	@Override
	public String toString() {
		return "Show [price=" + price + ", artistes=" + artistes + ", nom=" + nom + ", DateEvent=" + DateEvent + "]";
	}
	
	
	

}
