package be.iccbxl.poo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

public class Utils {

    public static void saveEventToFile(Evenement evenement, String fileName) {


        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Event", Evenement.class);
        xstream.useAttributeFor(Evenement.class, "texte");
        xstream.useAttributeFor(Evenement.class, "dateEvent");
        xstream.useAttributeFor(Evenement.class, "price");
        xstream.aliasField("titre", Evenement.class, "texte");
        xstream.aliasField("date", Evenement.class, "dateEvent");
        xstream.addPermission(AnyTypePermission.ANY);
        String xml = xstream.toXML(evenement);

        try {
            FileWriter writer = new FileWriter(fileName+".xml");
            writer.write(xml);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadEventFromFile(String fileName){

        File file = new File(fileName+".xml");
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
            String xml = new String(bytes);

            XStream xstream = new XStream(new DomDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.alias("Event", Evenement.class);
            Evenement evenement = (Evenement) xstream.fromXML(xml);
            System.out.println(evenement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
