package examen_poo_septembre2023;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class MyUtilities {

    // ... (autres méthodes et attributs)

    public static void saveToXML(Show show, String filename) {
        String strXML = "";

        XStream xs = new XStream(new DomDriver());

        // Security Configuration
        xs.addPermission(AnyTypePermission.ANY);

        // Configuration
        xs.alias("Show", Show.class);
        xs.useAttributeFor(Show.class, "texte");
        xs.aliasAttribute(Show.class, "texte", "title");
        xs.useAttributeFor(Show.class, "dateEvent");
        xs.aliasAttribute(Show.class, "dateEvent", "date");
        xs.useAttributeFor(Show.class, "price");

        strXML = xs.toXML(show);

        System.out.println(strXML);

        Path p = Paths.get(filename);

        try {
            Files.writeString(p, strXML, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Show loadFromXML(String filename) {
        Show show = null;
        String strXML = "";
        StringBuilder sb = new StringBuilder();

        Path p = Paths.get(filename);
        List<String> lines;

        try {
            lines = Files.readAllLines(p, StandardCharsets.UTF_8);
            Iterator<String> it = lines.iterator();

            while (it.hasNext()) {
                sb.append(it.next()).append("\n");
            }

            strXML = sb.toString();

            XStream xs = new XStream(new DomDriver());

            // Security Configuration
            xs.addPermission(AnyTypePermission.ANY);

            // Configuration
            xs.alias("Show", Show.class);
            xs.useAttributeFor(Show.class, "texte");
            xs.aliasAttribute(Show.class, "texte", "title");
            xs.useAttributeFor(Show.class, "dateEvent");
            xs.aliasAttribute(Show.class, "dateEvent", "date");
            xs.useAttributeFor(Show.class, "price");

            show = (Show) xs.fromXML(strXML);
            System.out.println(show);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return show;
    }
}