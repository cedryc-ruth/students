package poo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Path;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class MyUtilities {

    public static void main(String[] args) {

        String filename = "data.xml";
        Show show = new Show("Concert Rasta","Concert Rasta",50.0);
        

        Artist artist = new Artist("The King of Reggae", "Bob", "Marley", Style.RAGGAE);
        
        show.getArtistes().add(artist);
       

        saveShowToFile(filename, show);
    }

    public static Show loadShowFromFile(String filename) {
        File file = new File(filename);
        XStream xs = configXStream();

        return (Show) xs.fromXML(file);
    }

    public static void saveShowToFile(String filename, Show show) {

        XStream xs = configXStream();

        String xmlString = xs.toXML(show);

        List<String> lines = Arrays.asList(xmlString.split("\n"));

        Path path = Paths.get(filename);

        try {
            Files.deleteIfExists(path);
            Files.write(path, lines, StandardOpenOption.CREATE_NEW);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static XStream configXStream() {
        XStream xs = new XStream(new DomDriver());

        xs.addPermission(AnyTypePermission.ANY);

        xs.alias("Show", Show.class);
        xs.useAttributeFor(Show.class, "texte");
        xs.useAttributeFor(Show.class, "dateEvent");
        xs.useAttributeFor(Show.class, "price");
        xs.alias("artist", Artist.class);
        xs.useAttributeFor(Artist.class, "pseudo");
        xs.useAttributeFor(Artist.class, "fistname");
        xs.useAttributeFor(Artist.class, "lastname");
        xs.useAttributeFor(Artist.class, "style");

        return xs;
    }
}
