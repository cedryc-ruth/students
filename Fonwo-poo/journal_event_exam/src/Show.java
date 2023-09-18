import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Show extends Evenement implements Searchable{
    private double price;
    private ArrayList<Artist> artists;

    public Show(double price, String texte, DateTime dateEvent) {
        super(texte, dateEvent);
        this.price = price;
        this.artists = new ArrayList<>();
    }

    public Show(String texte, DateTime dateTimeEvent) {
        super(texte, dateTimeEvent);
        this.price = 0d;
        this.artists = new ArrayList<>();
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

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public List findBy(String s) {
        /* Méthode non impléméntée */
        return null;
    }

    @Override
    public String toString() {
        return texte + "\n"
                + "Date: " + dateEvent.format(DateTimeFormatter.ofPattern("d/m/y")) + "\n"
                + "Heure: " + dateEvent.format(DateTimeFormatter.ofPattern("H:m")) + "\n"
                + "Price: " + price + " €\n";
        /* Impléméntation incomplète : nombre d'artistes par style */
    }
}
