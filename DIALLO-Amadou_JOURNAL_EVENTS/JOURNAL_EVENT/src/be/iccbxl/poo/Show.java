package be.iccbxl.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import be.iccbxl.poo.exception.InvalidDateException;
import java.time.LocalDate;
import javax.xml.bind.annotation.*;



/**
 * La classe {@code Show} représente un événement de type spectacle musical.
 * Un spectacle musical a un titre, une date, un prix éventuel et une liste d'artistes.
 * Il peut être recherché par style musical.
 *
 * @author Diallo
 * @version 1.0
 * @since 2023-09-04
 */
@XmlRootElement(name = "Show")
@XmlAccessorType(XmlAccessType.FIELD)
public class Show extends Evenement implements Searchable {
    /**
     * Liste des artistes participant au spectacle.
     */
    @XmlElement(name = "artist")
    private ArrayList<Artist> artists;


    /**
     * Constructeur par défaut pour un spectacle gratuit.
     *
     * @param texte     Le titre du spectacle.
     * @param dateEvent La date du spectacle au format "yyyy-MM-dd'T'HH:mm".
     * @throws InvalidDateException Si la date du spectacle est un dimanche.
     */
    public Show(String texte, String dateEvent) {
        super(texte, LocalDate.from(LocalDateTime.parse(dateEvent, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))));
        // Vérifie si la date est un dimanche et lève une exception si c'est le cas
        if (getDateEvent().getDayOfWeek().getValue() == 7) {
            throw new InvalidDateException("La date est un dimanche.");
        }
        this.artists = new ArrayList<>();
    }


    /**
     * Constructeur pour un spectacle avec un prix spécifié.
     *
     * @param texte     Le titre du spectacle.
     * @param dateEvent La date du spectacle au format "yyyy-MM-dd'T'HH:mm".
     * @param price     Le prix du spectacle en euros.
     * @throws InvalidDateException Si la date du spectacle est un dimanche.
     */
    public Show(String texte, String dateEvent, double price) {
        super(texte, LocalDate.from(LocalDateTime.parse(dateEvent, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))), price);
        // Vérifie si la date est un dimanche et lève une exception si c'est le cas
        if (getDateEvent().getDayOfWeek().getValue() == 7) {
            throw new InvalidDateException("La date est un dimanche.");
        }
        this.artists = new ArrayList<>();
    }


    /**
     * Recherche et renvoie une liste d'artistes ayant un style musical correspondant
     * à la chaîne de caractères donnée.
     *
     * @param style Le style musical à rechercher (par exemple, "ROCK", "HIP HOP", "REGGAE").
     * @return Une liste d'artistes dont le style correspond à la chaîne spécifiée.
     */
    @Override
    public List<Artist> findBy(String style) {
        List<Artist> matchingArtists = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.getStyle().getStyle().equalsIgnoreCase(style)) {
                matchingArtists.add(artist);
            }
        }
        return matchingArtists;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }


    /**
     * Renvoie une représentation textuelle du spectacle, y compris son titre, sa date et heure,
     * son prix (ou "Gratuit" s'il est gratuit) et la liste des styles musicaux présents avec le nombre
     * d'artistes pour chaque style.
     *
     * @return La représentation textuelle du spectacle.
     */
    @Override
    public String toString() {
        Iterator<Artist> it = artists.iterator();
        StringBuilder styleCounts = new StringBuilder();
        while (it.hasNext()) {
            Artist m = it.next();
            styleCounts.append(m.getStyle().getStyle()).append(" (1 artiste)\n");
        }
        return getTexte() + " - " + getDateEvent().format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'à' HH:mm")) + " - " +
                (getPrice() > 0 ? getPrice() + " €" : "Gratuit") + "\n" + styleCounts.toString();
    }
}
