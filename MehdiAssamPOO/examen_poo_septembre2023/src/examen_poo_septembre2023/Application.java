package examen_poo_septembre2023;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) {
		
		// Création d'un événement
		Evenement evenement1 = new Evenement("Concert Rasta", LocalDateTime.of(2023, 9, 4, 20, 0));
		
		// Création d'artistes
		Artist artist1 = new Artist("The King of Reggae", "Bob", "Marley", Style.REGGAE);
		
		// Création d'une liste d'artistes
		ArrayList<Artist> artists = new ArrayList<>(Arrays.asList(artist1));
		
		// Création d'un spectacle
		Show show1 = new Show("Concert Rasta", LocalDateTime.of(2023, 9, 4, 20, 0), 50.0, artists);
		
		// Sérialisation du spectacle en XML
		MyUtilities.saveToXML(show1, "data/serialisation.xml");
		
		// Désérialisation du spectacle à partir du fichier XML
		Show deserializedShow = MyUtilities.loadFromXML("data/deserialisation.xml");
		
		// Affichage du spectacle désérialisé
		System.out.println("Show after deserialization: " + deserializedShow);
	}
}
