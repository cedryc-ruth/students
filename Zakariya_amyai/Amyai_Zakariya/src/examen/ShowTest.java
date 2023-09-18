package examen;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ShowTest {

	@Test
	void testShowConstrctShoulSucced() {
		Show s1 = new Show (("Concert Rasta","2023-09-04T20:00",50d));
		//verifier  que l'objet s1 a bien été créer'
		assertNotNull (s1);
		//verifier que l'objet a bien un nom
		asertEquals (s1.getNom(),"Concert Rasta"
		//véerifier que l'objet s1 possede une liste d'artise et que cette liste est vide au moment de création
		assertNotNull(s1.getArtistes());	
		assertEquals(s1.getArtistes().size(),0);
		//V�rifier qu'elle implemente l'interfaec Searchable
		assertTrue(s1 instanceof Searchable);
		//V�rifier qu'elle h�rite de le classe Evenement
		assertTrue(s1 instanceof Evenement);
		@Test
	
		void testShowConstrctShoulFailedInvalidDateException() {
			Festival f1 = new Festival("Show 1", LocalDateTime.of(2023-09-04T20:0)), "Show 1", false ,200);
			boolean error = false;
			try {
				f1.ajouterDate(LocalDateTime.of(2023-09-04T20:00));
			}catch(InvalidDateException e) {
				error = true;
			}
			
			//V�rifier que l'exception a bien �t� d�clancher
			assertTrue(error);
		
		
		
		