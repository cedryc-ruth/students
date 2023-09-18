package be.iccbxl.poo;

import java.time.LocalDateTime;

public class ShowSerializerTest {

    public static void main(String[] args) {
        // Créez un objet Show pour le tester
        Show show = new Show("Concert Rasta",  "2023-06-21T18:30", 50.0);

        // Ajoutez un artiste à ce spectacle
        Artist artist = new Artist();
        artist.setFirstname("Bob");
        artist.setLastname("Marley");
        artist.setStyle(Style.REGGAE);
        show.getArtists().add(artist);

        try {
            // Sauvegardez l'objet Show dans un fichier XML
            ShowSerializer.saveShowToFile(show, "show.xml");
            System.out.println("Show saved to show.xml");

            // Chargez l'objet Show depuis le fichier XML
            Show loadedShow = ShowSerializer.loadShowFromFile("show.xml");
            System.out.println("Show loaded from show.xml");

            // Affichez le spectacle chargé
            System.out.println("Loaded Show:");
            System.out.println(loadedShow.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
