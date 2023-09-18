package be.iccbxl.poo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ShowSerializer {


        // Méthode pour sauvegarder un objet Show dans un fichier XML
        public static void saveShowToFile(Show show, String filename) throws Exception {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(Show.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(show, file);
        }

        // Méthode pour charger un objet Show depuis un fichier XML
        public static Show loadShowFromFile(String filename) throws Exception {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(Show.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Show) unmarshaller.unmarshal(file);
        }

}
