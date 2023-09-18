package be.iccbxl.poo;

import be.iccbxl.poo.exception.InsufficientBalanceException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;


/**

 La classe Evenement permet de représenter un événement avec son texte, sa date, son prix, et la liste des membres inscrits.
 */


@XmlRootElement(name = "Event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Evenement implements  Registrable{
	@XmlAttribute
	private String texte;
	@XmlAttribute
	private LocalDate dateEvent;
	@XmlAttribute
	private double price;

	private ArrayList<Member> members;

	public Evenement() {
	}

	/**
	 Constructeur de la classe Evenement.
	 @param texte Le titre de l'événement.
	 @param dateEvent La date de l'événement.  */
	public Evenement(String texte, LocalDate dateEvent) {
		this.texte = texte;
		this.dateEvent = dateEvent;
	}

	/**
	 Constructeur de la classe Evenement.
	 @param texte Le titre de l'événement.
	 @param dateEvent La date de l'événement.
	 @param price Le prix de l'événement. */
	public Evenement(String texte, LocalDate dateEvent, double price) {
		this.texte = texte;
		this.dateEvent = dateEvent;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public LocalDate getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDate dateEvent) {
		this.dateEvent = dateEvent;
	}

	/**
	 Permet d'inscrire un membre à l'événement.
	 @param p Le membre à inscrire. */

	@Override
	public void register(Person p) throws InsufficientBalanceException {
		if(!(p instanceof Member)) {
			throw new InsufficientBalanceException("vous n'estes membre de l'evenement");
		}

		Member m = (Member) p;

		if(m.getMoney()<this.price) {
			throw new InsufficientBalanceException("Votre montant est insuffisant pour etre enregistrer a cet evenement");
		}

		this.members.add(m);
		m.getEvents().add(this);
	}




	/**
	 * Renvoie une représentation littérale de l'événement
	 */
	@Override
	public String toString() {
		Iterator<Member> it = members.iterator();
		StringBuilder membersList = new StringBuilder();

		while(it.hasNext()) {
			Member m = it.next();
			membersList.append("\t").append(m.getFirstname()).append(" ").append(m.getLastname()).append(" (").append(m.getStatus().toString().toLowerCase()).append(") - ").append(m.getMoney()).append(" €\n");
		}

		return texte + "\n"
				+ "Date: " + dateEvent.format(DateTimeFormatter.ofPattern("d/m/y")) + "\n"
				+ "Heure: " + dateEvent.format(DateTimeFormatter.ofPattern("H:m")) + "\n"
				+ "Prix: " + price + " €\n"
				+ "Inscrits :\n"+membersList.toString();
	}


}
