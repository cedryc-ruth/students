package be.iccbxl.poo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Show extends Evenement implements Searchable {
	
	/**
	 * Le prix du show
	 */
	private double price;
	
	/**
	 * La liste des artistes participant au show
	 */
	private ArrayList<Artist> artists;
	
	/**
	 * Cree un show avec le titre <code> texte </code> et le prix fourni <code> price</code> Si le jour du show tombe un dimanche
	 *  l'exception InvalidDateException de type RuntimeException est levé
	 * 
	 * La date et l'heure doivent etre fournies en suivant le format suivant : YYYY-MM-DDTHH:MM
	 * 
	 * @param texte represente le titre du show 
	 * @param dateEvent represente la date et l'heure du show
	 * @param price represente le prix du show
	 * @throws InvalidDateException de type RuntimeException est levé si le jour du show tombe un dimanche
	 */
	public Show(String texte, LocalDateTime dateEvent, double price) {
		super(texte,dateEvent);
		
		if (dateEvent.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new InvalidDateException("Les spectacles ne peuvent pas avoir lieu le dimanche.");
        }
		this.price = 0;
		this.artists = new ArrayList<>();
	}
	
	/**
	 * Cree un show avec le titre <code> texte </code> Si le jour du show tombe un dimanche
	 *  l'exception InvalidDateException de type RuntimeException est levé
	 * 
	 * La date et l'heure doivent etre fournies en suivant le format suivant : YYYY-MM-DDTHH:MM
	 * 
	 * @param texte represente le titre du show 
	 * @param dateEvent represente la date et l'heure du show
	 * @throws InvalidDateException de type RuntimeException est levé si le jour du show tombe un dimanche
	 */
	public Show(String texte, LocalDateTime dateEvent) {
		super(texte,dateEvent);
		
		if (dateEvent.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new InvalidDateException("Les spectacles ne peuvent pas avoir lieu le dimanche.");
        }
		this.artists = new ArrayList<>();
	}
	
	/**
	 * Renvoie le prix du show
	 * @return Renvoie le prix du show
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Modifie le prix du show
	 * @param price le nouveau prix du show
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Renvoie la liste des artistes participant au show
	 * @return la liste des artistes participant au show
	 */
	public ArrayList<Artist> getArtists() {
		return artists;
	}

	/**
	 * Modifie la liste des artistes participant au show
	 * @param artists, modifie la liste des artistes participant au show
	 */
	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}

	/**
	 * Renvoie une representation litterale de l'evenement
	 */
	@Override
	public String toString() {
		return "Show [price=" + price + ", artists=" + artists + "]";
	}
	
	/**
	 * Permet de rechercher dans un show les artistes par le style fourni en parametre
	 * 
	 * @param style Le style du show
	 * 
	 */
	@Override
	public List<Artist> findBy(String s) {
        List<Artist> matchingArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getStyle().equals(s)) {
                matchingArtists.add(artist);
            }
        }
        return matchingArtists;
    }
	
	
	
//=========================SEREALISATION==============================
	public String toXMLString() {
		//Instancier
		XStream xs = new XStream(new DomDriver());
		
		//Configurer XStream
		xs.alias("Show", Show.class);
		xs.useAttributeFor(Show.class, "texte");
		xs.useAttributeFor(Show.class, "price");
		xs.aliasAttribute(Evenement.class, "texte", "title");
		xs.alias("Artist", Artist.class);
		
		//Convertir en XML
		String xmlString = xs.toXML(this);
		
		return xmlString;
	}
	
	private static Show fromXMLString(String xmlString) {
		Show show = null;
		
		//Instancier
		XStream xs = new XStream(new DomDriver());
		
		//Configurer XStream
		xs.addPermission(AnyTypePermission.ANY);
		xs.alias("Show", Show.class);
		xs.useAttributeFor(Show.class, "texte");
		xs.useAttributeFor(Show.class, "price");
		xs.aliasAttribute(Evenement.class, "texte", "title");
		xs.alias("Artist", Artist.class);
		
		//Convertir en Objet
		show = (Show) xs.fromXML(xmlString);
		
		return show;
	}
	
	public static void saveXMLToFile(String xml, String filename) {
		Path path = Paths.get(filename);
		
		try {
			Files.writeString(path, xml, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String readFromXMLFile(String filename) {
		Path path = Paths.get(filename);
		String xmlString = null;		
		try {
			xmlString = Files.readString(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xmlString;
	}

	public static void main(String[] args) {
	
	Show s1 = new Show("Concert Rasta", LocalDateTime.of(2023, 9, 04, 20, 00));
	Artist art = new Artist("The King of Reggae", "Bob", "Marley");
	art.setStyle(Style.REGGAE);
	ArrayList<Artist> artist = new ArrayList<>();
	artist.add(art);
	s1.setArtists(artist);
	s1.setPrice(50d);
	
	
	String xmlString = s1.toXMLString();
	
	System.out.println(xmlString);
	
	Show.saveXMLToFile(xmlString, "data/shows.xml");
	
	
	Show s2 = null;
	
	xmlString = Show.readFromXMLFile("data/shows.xml");
	
	s2 = Show.fromXMLString(xmlString);
	
	System.out.println(s2);
	System.out.println(s1);
	}

}