package be.iccbxl.poo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La classe Show représente un événement de type spectacle.
 * Elle hérite de la classe Evenement et implémente l'interface Searchable.
 * Un objet Show est caractérisé par son texte, sa date et heure, son prix, ainsi que la liste des artistes invités.
 */

public class Show extends Evenement implements Searchable {
	
	 /** Le prix du spectacle. */
    private double price;

    /** La liste des artistes invités au spectacle. */
    private List<Artiste> artists;
    
    /**
     * Constructeur de la classe Show.
     *
     * @param texte Le texte décrivant le spectacle.
     * @param dateEvent La date et l'heure du spectacle.
     * @param price Le prix du spectacle en euros.
     * @param artists La liste des artistes invités au spectacle.
     */

    
    public Show(String texte, Date dateEvent, double price, List<Artiste> artists) {
        super(texte, dateEvent);
        this.price = price;
        this.artists = artists;
    }
    
    

	


	/**
     * Obtient le prix du spectacle.
     *
     * @return Le prix du spectacle en euros.
     */

    
    public double getPrice() {
        return price;
    }
    
    /**
     * Modifie le prix du spectacle.
     *
     * @param price Le nouveau prix du spectacle en euros.
     */

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    /**
     * Obtient la liste des artistes invités au spectacle.
     *
     * @return La liste des artistes invités.
     */

   
    public List<Artiste> getArtists() {
        return artists;
    }
    

    /**
     * Modifie la liste des artistes invités au spectacle.
     *
     * @param artists La nouvelle liste des artistes invités.
     */

    public void setArtists(List<Artiste> artists) {
        this.artists = artists;
    }
    
    /**
     * Recherche les artistes du spectacle par style musical.
     *
     * @param s Le style musical à rechercher sous forme de chaîne de caractères.
     * @return Une liste des artistes dont le style correspond à la chaîne fournie.
     */
    
    /**
     * Retourne une représentation sous forme de chaîne de caractères des informations du spectacle,
     * y compris son texte, sa date et heure, son prix, ainsi que la liste des styles musicaux avec
     * le nombre d'artistes de chaque style.
     *
     * @return Une chaîne de caractères représentant les informations du spectacle.
     */

    public List<Artiste> findBy(String s) {
        List<Artiste> matchingArtists = new ArrayList<>();

        for (Artiste artist : artists) {
            if (artist.getStyle().toString().equalsIgnoreCase(s)) {
                matchingArtists.add(artist);
            }
        }

        return matchingArtists;
    }
    
    /**
     * Retourne une représentation sous forme de chaîne de caractères des informations du spectacle,
     * y compris son texte, sa date et heure, son prix, ainsi que la liste des styles musicaux avec
     * le nombre d'artistes de chaque style.
     *
     * @return Une chaîne de caractères représentant les informations du spectacle.
     */
    
    @Override
    public String toString() {
        String result = "Spectacle : " + this.getTexte() + "\n";
        result += "Date et heure : " + this.getDateEvent() + "\n";
        result += "Prix : " + this.getPrice() + "\n";

        Map<String, Integer> styles = new HashMap<>();
        for (Artiste artiste : this.getArtists()) {
            styles.put(artiste.getStyle(), styles.getOrDefault(artiste.getStyle(), 0) + 1);
        }

        result += "Styles musicaux :\n";
        for (String style : styles.keySet()) {
            result += "    " + style + " ( " + styles.get(style) + " artiste(s) )\n";
        }

        return result;
    }
    
    
    
    
}