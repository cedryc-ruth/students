package poo;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShowTest {
	private Show s;
	private ArrayList<Artist> artists;
	

	@BeforeEach
	void setUp() throws Exception {
		 
		    
		s = new Show("Fête de la musique", LocalDateTime.of(2023, 10, 30, 18, 30), 0.0d , artists);
	
	}

	

	@Test
	void testShow() {
		assertTrue(s instanceof Evenement);
		assertTrue(s instanceof Searchable);
		
		assertEquals("Fête de la musique", s.getTexte());
		assertEquals(2023, s.getDateEvent().getYear());
		assertEquals(10, s.getDateEvent().getMonth());
		assertEquals(30, s.getDateEvent().getDayOfMonth());
		assertEquals(18, s.getDateEvent().getHour());
		assertEquals(30, s.getDateEvent().getMinute());
		assertEquals(0.0d, s.getPrice());
		assertEquals(0, s.getArtists().size()); // assertTrue(s.getAtists().isEmpty());  La liste d'artistes doit être vide par défaut
	
	
    }
	 @Test
	    public void testConstructorWithPrice() {
	        s = new Show("Concert Rasta", LocalDateTime.of(2023, 9, 4, 20, 00), 50.0);
	        assertEquals("Concert Rasta", s.getTexte());
	        assertEquals(LocalDateTime.of(2023, 9, 4, 20, 00), s.getDateEvent());
	        assertEquals(50.0, s.getPrice()); // Le prix doit être correctement défini
	        assertTrue(s.getArtists().isEmpty()); // La liste d'artistes doit être vide
	    }
	
	
	  @Test
	    public void testInvalidDateException() {
	        assertThrows(InvalideDateException.class, () -> {
	            new Show("Invalid Date Show", LocalDateTime.of(2023, 9, 5, 20, 0));
	        });
	    }
	  
	  
	  @Test
		void testToString() {
			String st = "Fête de la musique – 21/06/2023 à 18:30 - Gratuit /n"
					+ "- ROCK (4 artistes)/n"
					+ "- HIP HOP (2 artistes) /n"
					+ "- REGGAE (1 artiste)";

			assertEquals(st, s.toString());
		}
	
	
	@Test
	void testFindBy() {
		Artist rockArtist1 = new Artist("Artist1", "ROCK");
        Artist rockArtist2 = new Artist("Artist2", "ROCK");
        Artist hipHopArtist1 = new Artist("Artist3", "HIP HOP");
        
        s.getArtists().add(rockArtist1);
        s.getArtists().add(rockArtist2);
        s.getArtists().add(hipHopArtist1);

        
        List<String> rockArtists = s.findBy("ROCK");
        assertEquals(2, rockArtists.size());
        assertTrue(rockArtists.contains("Artist1"));
        assertTrue(rockArtists.contains("Artist2"));
        assertFalse(rockArtists.contains("Artist3")); // Cet artiste n'est pas du style ROCK
   
	}

}
