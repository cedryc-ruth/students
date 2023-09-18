import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistTest {
    private Artist artist;

    @BeforeEach
    void setUp() throws Exception {
        artist = new Artist("The king of Reggae", "Bob", "Reggae", "Reggae");
    }

    @Test
    void testMemberStringStringCharString() {
        assertTrue(artist instanceof Artist);
        assertEquals(Style.HIPHOP, artist.getStyle());
        assertEquals("Bob", artist.getFirstName());
        assertEquals("Marley", artist.getLastName());

    }

    @Test
    void testToString() {
        String result = "Bob Marley \n"
                + "\t- The king of Reggae\n"
                + "\t- The queen of pop\n";
    }
}
