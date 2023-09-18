package pootest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poo.Artist;
import poo.Evenement;
import poo.InvalidDateException;
import poo.Searchable;
import poo.Show;

class ShowtestTest {
	
	private Show show; 

	@BeforeEach
	void setUp() throws Exception {
		Show show =new Show("Concert Rasta","2023-09-04T20:00",50d);


	}
	@Test
    public void testShowWithPrice() {
        assertTrue(show instanceof  Searchable);
        assertTrue(show instanceof Evenement);
        
        
        assertEquals("Concert Rasta", show.getTexte());
		assertEquals(2024, show.getDateEvent().getYear());
        assertEquals(9, show.getDateEvent().getMonth());
		assertEquals(04, show.getDateEvent().getDayOfMonth());
		assertEquals(20, show.getDateEvent().getHour());
		assertEquals(00, show.getDateEvent().getMinute());
        assertEquals(50.0, show.getPrice(), 0.01);
        assertTrue(show.getArtist().isEmpty());
        
	}
	
	@Test
    public void testShowWithoutPrice() {
        Show show = new Show("Fête de la musique", "2023-06-21T18:30" );
        
        assertEquals("Fête de la musique", show.getTexte());
		assertEquals(2023, show.getDateEvent().getYear());

    	assertEquals(06, show.getDateEvent().getMonth());
		assertEquals(21, show.getDateEvent().getDayOfMonth());
		assertEquals(21, show.getDateEvent().getHour());
		assertEquals(30, show.getDateEvent().getMinute());
        assertEquals(0.0, show.getPrice(), 0.01);
        assertTrue(show.getArtist().isEmpty());
    }
	
	
    @Test
    public void testFindByMatchingStyle() {
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Artist 1", "Reggae"));
        artists.add(new Artist("Artist 2", "Hip-Hop"));
        artists.add(new Artist("Artist 3", "Reggae"));
        
        Show show = new Show("Concert Rasta", "2023-09-04T20:00", 50.0);
        show.setArtist(artists);
        
        ArrayList<Artist> result = (ArrayList<Artist>) show.findBy("Reggae");
        
        assertEquals(2, result.size());
        assertEquals("Artist 1", result.get(0).getFirstname());
        assertEquals("Artist 3", result.get(1).getFirstname());
    }
    
    @Test
    public void testFindByNonMatchingStyle() {
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Artist 1", "Rock"));
        artists.add(new Artist("Artist 2", "Pop"));
        
        Show show = new Show("Fête de la musique", "2023-06-21T18:30");
        show.setArtist(artists);
        
        ArrayList<Artist> result = (ArrayList<Artist>) show.findBy("Reggae");
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testToString() {
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Artist 1", "ROCK"));
        artists.add(new Artist("Artist 2", "ROCK"));
        artists.add(new Artist("Artist 3", "HIP HOP"));
        artists.add(new Artist("Artist 4", "ROCK"));
        artists.add(new Artist("Artist 5", "HIP HOP"));
        artists.add(new Artist("Artist 6", "REGGAE"));
        
        Show show = new Show("Fête de la musique", "2023-06-21T18:30");
        show.setArtist(artists);
        
        String expected = "Fête de la musique – 21/06/2023 à 18:30 - Gratuit\n" +
                                "- ROCK (4 artistes)\n" +
                                "- HIP HOP (2 artistes)\n" +
                                "- REGGAE (1 artiste)";
        
        assertEquals(expected, show.toString());
    }
    
    @Test
    public void testCreateShowOnSunday() {
    	
    	 assertThrows(InvalidDateException.class, () -> {
    		 new Show("Le Show du dimanche ", "2023-09-10T15:00", 20.0); });
    	 
    }
}
    

	



