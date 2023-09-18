package examen_poo_septembre2023;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShowTest {
	
	private Show show1;
	private Show show2;
	private ArrayList<Artist> artists = new ArrayList<>();
	private Artist artist1;
	private Artist artist2;

	@BeforeEach
	void setUp() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateEvent1 = LocalDateTime.parse("2023-09-04T20:00", formatter);
		LocalDateTime dateEvent2 = LocalDateTime.parse("2023-06-21T18:30", formatter);
		
		artist1 = new Artist("John", "Doe", "ROCK");
		artist2 = new Artist("Jane", "Doe", "HIP_HOP");
		
		artists.add(artist1);
		artists.add(artist2);
		
		show1 = new Show("Concert Rasta", dateEvent1, 50d, artists);
		show2 = new Show("Fête de la musique", dateEvent2);
	}

	@Test
	void testConstructor() {
		// Verification
		assertTrue(show1 instanceof Evenement);
		assertTrue(show1 instanceof Searchable);
		
		assertEquals("Concert Rasta", show1.getTexte());
		assertEquals(LocalDateTime.parse("2023-09-04T20:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")), show1.getDateEvent());
		assertEquals(50d, show1.getPrice());
		assertNotNull(show1.getArtists());
		assertEquals(2, show1.getArtists().size());
		
		assertEquals("Fête de la musique", show2.getTexte());
		assertEquals(0d, show2.getPrice()); // Gratuit par défaut
	}

	@Test
	void testInvalidDateException() {
		// Preparation
		LocalDateTime sundayDate = LocalDateTime.parse("2023-09-03T20:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		
		// Verification
		assertThrows(InvalidDateException.class, () -> {
			new Show("Concert Rasta", sundayDate, 50d, artists);
		});
	}

	@Test
	void testFindBy() {
		// Utilisation
		List<Artist> rockArtists = show1.findBy("ROCK");
		
		// Verification
		assertNotNull(rockArtists);
		assertEquals(1, rockArtists.size());
		assertTrue(rockArtists.contains(artist1));
	}

	@Test
	void testToString() {
		// Preparation
		String expected = "Fête de la musique – 21/06/2023 à 18:30 - Gratuit\n" +
		                  "- ROCK (1 artistes)\n" +
		                  "- HIP_HOP (1 artistes)";
		
		// Verification
		assertEquals(expected, show2.toString());
	}
}