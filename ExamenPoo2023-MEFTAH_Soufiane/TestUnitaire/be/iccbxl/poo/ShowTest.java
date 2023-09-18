package be.iccbxl.poo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.FormattedDateConversion;

class ShowTest {
	 @Test
	    public void testConstructeur() {
	        // Test avec les paramètres par défaut du constructeur
	        Show show1 = new Show("Concert Rasta", new Date(123456789), 0, new ArrayList<>());
	        assertEquals("Concert Rasta", show1.getTexte());
	        assertEquals(new Date(123456789), show1.getDateEvent());
	        assertEquals(0, show1.getPrice());

	        // Test avec un prix qui n'est pas nul
	        Show show2 = new Show("Concert de rock", new Date(987654321), 50, new ArrayList<>());
	        assertEquals(50, show2.getPrice());

	        // Test avec une date invalide (dimanche)
	        assertThrows(InvalidDateException.class, () -> new Show("Concert de rock", new Date(2023, 6, 25, 20, 0), 50, new ArrayList<>()));
	    }
	
	 @Test
	    public void testFindBy() {
	        // Test avec une liste d'artistes
	        List<Artiste> artists = new ArrayList<>();
	        artists.add(new Artiste("The Beatles", "Rock"));
	        artists.add(new Artiste("Pink Floyd", "Rock"));
	        artists.add(new Artiste("AC/DC", "Rock"));
	        artists.add(new Artiste("Eminem", "Hip Hop"));
	        artists.add(new Artiste("Jay-Z", "Hip Hop"));
	        artists.add(new Artiste("Bob Marley", "Reggae"));
	        Show show = new Show("Fête de la musique", new Date(987654321), 0, artists);

	        List<String> expectedRock = new ArrayList<>();
	        expectedRock.add("The Beatles");
	        expectedRock.add("Pink Floyd");
	        expectedRock.add("AC/DC");
	        assertEquals(expectedRock, show.findBy("Rock"));

	        List<String> expectedHipHop = new ArrayList<>();
	        expectedHipHop.add("Eminem");
	        expectedHipHop.add("Jay-Z");
	        assertEquals(expectedHipHop, show.findBy("Hip Hop"));

	        List<String> expectedReggae = new ArrayList<>();
	        expectedReggae.add("Bob Marley");
	        assertEquals(expectedReggae, show.findBy("Reggae"));

	        // Test avec une liste vide
	        show = new Show("Concert de rock", new Date(987654321), 0, new ArrayList<>());
	        assertEquals(new ArrayList<>(), show.findBy("Rock"));

	        // Test avec une chaîne de caractères vide
	        show = new Show("Concert de rock", new Date(987654321), 0, artists);
	        assertEquals(new ArrayList<>(), show.findBy(""));

	        // Test avec une chaîne de caractères nulle
	        show = new Show("Concert de rock", new Date(987654321), 0, artists);
	        assertEquals(new ArrayList<>(), show.findBy(null));
	    }
	 @Test
	 public void testToString() {
	     List<Artiste> artists = new ArrayList<>();
	     artists.add(new Artiste("The Beatles", "Rock"));
	     artists.add(new Artiste("Pink Floyd", "Rock"));
	     artists.add(new Artiste("AC/DC", "Rock"));
	     artists.add(new Artiste("Eminem", "Hip Hop"));
	     artists.add(new Artiste("Jay-Z", "Hip Hop"));
	     artists.add(new Artiste("Bob Marley", "Reggae"));
	     Show show = new Show("Fête de la musique", new Date(2023, 6, 21, 18, 30), 0, artists);

	     String expected = "Fête de la musique - 21/06/2023 à 18:30 - Gratuit\n" +
	             "- ROCK (3 artistes)\n" +
	             "- HIP HOP (2 artistes)\n" +
	             "- REGGAE (1 artiste)\n";
	     assertEquals(expected, show.toString());

	     // Test avec une liste vide
	     show = new Show("Concert de rock", new Date(2023, 7, 20, 20, 0), 0, new ArrayList<>());
	     expected = "Concert de rock - 20/07/2023 à 20:00 - Gratuit\n";
	     assertEquals(expected, show.toString());
	 }
}
