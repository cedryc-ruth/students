package examen_poo_septembre2023;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Représente un spectacle (Show)
 * 
 * @author Mehdi Assam
 * @version 1.0
 * @since 04/09/2023
 *
 */
public class Show extends Evenement implements Searchable {
	
	/**
	 * Le prix du spectacle
	 */
	private Double price;
	
	/**
	 * La liste des artistes participant au spectacle
	 */
	private List<Artist> artists;

	/**
	 * Crée un nouveau spectacle avec des valeurs spécifiées
	 * 
	 * @param texte Le texte ou le nom du spectacle
	 * @param dateEvent La date et l'heure du spectacle
	 * @param price Le prix du spectacle
	 * @param artists La liste des artistes participant au spectacle
	 */
	public Show(String texte, LocalDateTime dateEvent, Double price, List<Artist> artists) {
		super(texte, dateEvent);
		this.price = price;
		this.artists = artists;
	}

	/**
	 * Crée un nouveau spectacle avec un prix par défaut de 0.00 (gratuit) et une liste d'artistes vide
	 */
	public Show(String texte, LocalDateTime dateEvent) {
		super(texte, dateEvent);
		this.price = 0.00;
		this.artists = new ArrayList<>();
	}

	/**
	 * 
	 * @return Le prix du spectacle
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Modifie le prix du spectacle
	 * 
	 * @param price Le nouveau prix
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return La liste des artistes participant au spectacle
	 */
	public List<Artist> getArtists() {
		return artists;
	}

	/**
	 * Modifie la liste des artistes participant au spectacle
	 * 
	 * @param artists La nouvelle liste d'artistes
	 */
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	/**
	 * Recherche des artistes par style musical
	 * 
	 * @param s Le style musical
	 * @return La liste des artistes ayant le style musical spécifié
	 */
	@Override
	public List<Artist> findBy(String s) {
		List<Artist> foundArtists = new ArrayList<>();
		for (Artist artist : artists) {
			if (artist.getStyle().equals(s)) {
				foundArtists.add(artist);
			}
		}
		return foundArtists;
	}

	/**
	 * Représentation littérale du spectacle
	 * 
	 * @return Une chaîne de caractères représentant le spectacle
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTexte()).append(" – ").append(getDateEvent().format(DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm")));
		sb.append(" - ").append(price == 0 ? "Gratuit" : price + " €").append("\n");

		Map<String, Integer> styleCounts = new HashMap<>();
		for (Artist artist : artists) {
			styleCounts.put(artist.getStyle(), styleCounts.getOrDefault(artist.getStyle(), 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : styleCounts.entrySet()) {
			sb.append("- ").append(entry.getKey()).append(" (").append(entry.getValue()).append(" artistes)\n");
		}

		return sb.toString();
	}
}
