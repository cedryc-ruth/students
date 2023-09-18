package examen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Service {

	public static Show loadFromXML(String filename) {
		Show Show = null;
		String strXML = "";
		StringBuilder sb = new StringBuilder();
		
		//Lire le fichier XML
		Path p = Paths.get(filename);
		List lines = null;
		
		try {
			lines = Files.readAllLines(p, StandardCharsets.UTF_8);
			
			Iterator<String> it = lines.iterator();
			
			while(it.hasNext()) {
				sb.append(it.next()+"\n");
			}
			
			strXML = sb.toString();
			
			//Convertir la liste en objet Site
			XStream xs = new XStream(new DomDriver());
			
			//Security Configuration
			xs.addPermission(AnyTypePermission.ANY);
						
			//Configuration
			xs.alias("Show", Show.class);
			
			xs.useAttributeFor(Show.class, "nom");
			xs.useAttributeFor(Show.class, "free");
			
			
			xs.aliasField("dateEvent", Evenement.class, "date");
			xs.alias("date", LocalDatetime.class);
			
			xs.addImplicitCollection(Show.class, "artiste");

			xs.alias("artiste", Artist.class);
			xs.useAttributeFor(Artist.class, "pseudo");
			xs.useAttributeFor(Artist.class, "fisrtname");
			xs.useAttributeFor(Artist.class, "lastname");
			xs.useAttributeFor(Artist.class, "syle");
			
			
						
			Show = (Show) xs.fromXML(strXML);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Show;
	}
	

	public static void saveToXML(Show show, String filename) {
		String strXML = null;
		
		XStream xs = new XStream(new DomDriver());
		xs.autodetectAnnotations(true);
		//Security Configuration
		xs.addPermission(AnyTypePermission.ANY);
		
		//Configuration
		xs.alias("Festival", Show.class);
		
		xs.useAttributeFor(Show.class, "nom");
		xs.useAttributeFor(Show.class, "free");
		
		xs.aliasField("dateEvent", Evenement.class, "date");
		xs.alias("date", LocalDate.class);
		
		xs.addImplicitCollection(Show.class, "artiste");

		xs.alias("Artistes", Artist.class);
		xs.useAttributeFor(Artist.class, "pseudo");
		xs.useAttributeFor(Artist.class, "fisrtname");
		xs.useAttributeFor(Artist.class, "lastname");
		xs.useAttributeFor(Artist.class, "syle");
	
		strXML = xs.toXML(festival);
		
		System.out.println(strXML);
		
		
		File f = new File(filename);
		
		//Suppression du fichier s'il existe d�j�
		if(f.exists()) {
			f.delete();
		}
		
		//Sauver le texte dans un fichier
		Path p = Paths.get(filename);
		
		try {
			Files.writeString(p, strXML, StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}

