import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.TypePermission;

public class MyUtilities {
    public static Show loadShowFromFile(String filename) {
        Show show = null;
        Path path = Paths.get(filename);
        String content = null;

        if(!Files.exists(path)) {
            throw new RuntimeException("Fichier introuvable");
        }

        try {
            content = Files.readString(path);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Probleme de lecture");
        }

        XStream xs = new XStream(new DomDriver());
        configure(xs);

        show = (Show) xs.fromXML(content);

        return show;
    }

    public static void saveShowToFile(Show s, String filename) {
        String xmlString = null;
        Path path = Paths.get(filename);

        XStream xs = new XStream(new DomDriver());

        //Configuration
        configure(xs);

        xmlString = xs.toXML(s);

        //Ecriture du fichier
        try {
            Files.writeString(path, xmlString, Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        } catch (IOException e1) {
            e1.printStackTrace();
            throw new RuntimeException("Problème d'écriture!");
        }
    }

    private static void configure(XStream xs) {
        xs.addPermission(AnyTypePermission.ANY);

        xs.alias("Show", Show.class);
        xs.useAttributeFor(Show.class, "texte");
        xs.aliasAttribute("title", "texte");
        xs.useAttributeFor(Show.class, "dateEvent");
        xs.aliasAttribute("date", "dateEvent");
        xs.useAttributeFor(Show.class, "price");
        xs.addImplicitCollection(Show.class, "artists");
        xs.alias("artirst", Artist.class);
        xs.omitField(Artist.class, "firstname");
    }
}
