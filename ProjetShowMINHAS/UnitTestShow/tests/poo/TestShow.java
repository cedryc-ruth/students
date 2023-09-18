package poo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import poo.Searchable;

class TestShow {
	
	Show show = new Show("TommorowLand", LocalDate.now());
	Show s = new Show("Concert Rasta","2023-09-04T20:00",50d);
	
	Artist bob = new Artist("Loco", "Bob", "Sull", Style.RAGGAE);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@Test
	void testShow() {
		assertTrue(s instanceof Evenement);
		assertTrue(s instanceof Searchable);
		
		assertNotNull(s);
		assertNotNull(show);
		
		
		assertEquals("Concert Rasta", s.getTexte());
		assertEquals("2023-09-04T20:00", s.getDateEvent());
		assertEquals(50d, s.getPrice());
		
		
		assertEquals("Concert Rasta", s.getTexte());
		assertEquals(2023, s.getDateEvent().getYear());
		assertEquals(9, s.getDateEvent().getMonth());
		assertEquals(04, s.getDateEvent().getDayOfMonth());
		
		
	}
	
	@Test
	void testThrowsExceptionSunday() {
		LocalDate sundayDate = LocalDate.of(2023, 9, 3);
		assertThrows(InvalidDateException.class, ()-> {
			Show show = new Show("Titre du spectacle", sundayDate);
			
		});
		
	}
	
	@Test
	void testFindBy() {
		ArrayList<Artist> ar = new ArrayList<Artist>();  
		assertNull(ar);
		
		ar.add(bob);
		
		assertNotNull(ar);
		assertNotNull(s.getArtistes().contains(bob));
		assertEquals(s.getArtistes(), s.findBy("bob"));
		assertEquals(1, ar.size());
		
		
	}
	
	@Test
	void testToString() {
		String expected = "Fête de la musique – 21/06/2023 à 18:30 - Gratuit\r\n"
				+ "-	ROCK (4 artistes)\r\n"
				+ "-	HIP HOP (2 artistes)\r\n"
				+ "-	REGGAE (1 artiste)\r\n";
		assertEquals(expected, s.toString());
		
		
				
	}

}
