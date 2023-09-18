package be.iccbxl.poo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyUtilities {
	
	private static XStream xStream;

	// Méthode pour sérialiser un objet Show en XML et l'enregistrer dans un fichier
    public static void saveShowToFile(Show show, String filename) {
        XStream xStream = new XStream(new DomDriver());
        
        String xml = xStream.toXML(show);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Méthode pour désérialiser un fichier XML en un objet Show
    public static Show loadShowFromFile(String filename) {
        XStream xStream = new XStream(new DomDriver());
        try (FileReader reader = new FileReader(filename)) {
            return (Show) xStream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void configure() {
        // Configurer les alias de classe
        xStream.alias("Show", Show.class);
        xStream.alias("artist", Artiste.class);

        // Configurer les attributs
        xStream.useAttributeFor(Show.class, "title");
        xStream.useAttributeFor(Show.class, "date");
        xStream.useAttributeFor(Show.class, "price");

        // Configurer les collections implicites (artistes)
        xStream.addImplicitCollection(Show.class, "artists");

        // Configurer les champs omis
        xStream.omitField(Artiste.class, "style");
    }   
}
