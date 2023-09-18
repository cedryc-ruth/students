package be.iccbxl.poo;

import java.util.ArrayList;
import java.util.Date;

public class Application {

	public static void main(String[] args) {
		
		  // Créer un objet Show
        Show show = new Show("Concert de rock", new Date(), 0,
                new ArrayList<Artiste>() {{
                    add(new Artiste("The Beatles", "Rock"));
                    add(new Artiste("Pink Floyd", "Rock"));
                    add(new Artiste("AC/DC", "Rock"));
                }});

        // Configurer XStream
        MyUtilities.configure();

        // Sauvegarder l'objet Show dans un fichier XML
        MyUtilities.saveShowToFile(show, "show.xml");

        // Chargement du fichier XML et conversion en objet Show
        Show show2 = MyUtilities.loadShowFromFile("show.xml");

        // Afficher les informations du spectacle
        System.out.println("Titre : " + show2.getTexte());
        System.out.println("Date : " + show2.getDateEvent());
        System.out.println("Prix : " + show2.getPrice());
        System.out.println("Artistes :");
        for (Artiste artiste : show2.getArtists()) {
            System.out.println("    - " + artiste.getFirstname());
        }
    }

}
