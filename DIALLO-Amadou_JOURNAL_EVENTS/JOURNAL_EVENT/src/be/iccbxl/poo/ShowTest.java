package be.iccbxl.poo;

import static org.junit.Assert.*;

import be.iccbxl.poo.exception.InvalidDateException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ShowTest {
    private Show show;

    @Before
    public void setUp() {
        // Initialisation commune pour les tests
        show = new Show("Fête de la musique", "2023-06-21T18:30");
    }

    @Test
    public void testConstructor() {
        assertEquals("Fête de la musique", show.getTexte());
        assertEquals("2023-06-21T18:30", show.getDateEvent().toString());
        assertEquals(0.0, show.getPrice(), 0.001); // Vérifie que le prix par défaut est 0.0
        assertNotNull(show.getArtists()); // Vérifie que la liste d'artistes n'est pas nulle
    }

    @Test(expected = InvalidDateException.class)
    public void testInvalidDateConstructor() {
        // Devrait lever une exception car la date est un dimanche
        new Show("Concert Rasta", "2023-09-03T20:00", 50.0);
    }

    @Test
    public void testFindBy() {
        Artist artist1 = new Artist();
        artist1.setStyle(Style.ROCK);
        show.getArtists().add(artist1);

        Artist artist2 = new Artist();
        artist2.setStyle(Style.HIP_HOP);
        show.getArtists().add(artist2);

        Artist artist3 = new Artist();
        artist3.setStyle(Style.HIP_HOP);
        show.getArtists().add(artist3);

        Artist artist4 = new Artist();
        artist4.setStyle(Style.ROCK);
        show.getArtists().add(artist4);

        List<Artist> rockArtists = show.findBy("ROCK");
        assertEquals(2, rockArtists.size()); // Vérifie que 2 artistes de style ROCK sont trouvés

        List<Artist> hipHopArtists = show.findBy("HIP HOP");
        assertEquals(2, hipHopArtists.size()); // Vérifie que 2 artistes de style HIP HOP sont trouvés

        List<Artist> reggaeArtists = show.findBy("REGGAE");
        assertEquals(0, reggaeArtists.size()); // Aucun artiste de style REGGAE ne devrait être trouvé
    }

    @Test
    public void testToString() {
        // Ajoutez des artistes au spectacle pour tester toString()
        Artist artist1 = new Artist();
        artist1.setStyle(Style.ROCK);
        show.getArtists().add(artist1);

        Artist artist2 = new Artist();
        artist2.setStyle(Style.HIP_HOP);
        show.getArtists().add(artist2);

        Artist artist3 = new Artist();
        artist3.setStyle(Style.HIP_HOP);
        show.getArtists().add(artist3);

        Artist artist4 = new Artist();
        artist4.setStyle(Style.REGGAE);
        show.getArtists().add(artist4);

        String expected = "Fête de la musique - 21/06/2023 à 18:30 - Gratuit\n" +
                "ROCK (1 artiste)\n" +
                "HIP HOP (2 artistes)\n" +
                "REGGAE (1 artiste)\n";

        assertEquals(expected, show.toString());
    }
}