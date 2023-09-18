import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShowTest {

    private Show show1;
    private Show show2;
    private Artist artist;

    @BeforeEach
    void setUp() throws Exception{
        show1 = new Show(50d, "Concert Rasta", "2023-09-04T20:00");
        show2 = new Show(0d, "Fête de la musique","2023-06-21T18:30");
        artist = new Artist("The King of Reggae", "Bob", "Marley","REGGAE");
    }

    @Test
    void testShow() {
        assertTrue(show1 instanceof Searchable);
        assertEquals("Concert Rasta", show1.getTexte());
        assertEquals("Fête de la musique", show2.getTexte());
        assertEquals(2023, show1.getDateEvent().getYear());
        assertEquals(9, show1.getDateEvent().getMonth());
        assertEquals(30, show1.getDateEvent().getMonth());
        assertEquals(20, show1.getDateEvent().getHour());
        assertEquals(00, show1.getDateEvent().getMinute());
        assertEquals(50d, show1.getPrice());
        assertEquals(0, show1.getArtists().size());
        assertEquals(2023, show2.getDateEvent().getYear());
        assertEquals(06, show2.getDateEvent().getMonth());
        assertEquals(21, show2.getDateEvent().getMonth());
        assertEquals(18, show2.getDateEvent().getHour());
        assertEquals(30, show2.getDateEvent().getMinute());
        assertEquals(0d, show2.getPrice());
        assertEquals(0, show2.getArtists().size());

    }

    @Test
    void testShowGratuit() {
    show1 = new Show("Concert Rasta", "2023-09-04T20:00");
    assertEquals(0d, show1.getPrice());
    }

}