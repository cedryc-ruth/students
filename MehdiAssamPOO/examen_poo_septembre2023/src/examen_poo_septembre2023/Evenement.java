package examen_poo_septembre2023;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evenement {
	private String texte;
	private LocalDateTime dateEvent;
	
	public Evenement() {
		this.texte = "Concert Rasta";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		this.dateEvent = LocalDateTime.parse("04/09/2023 20:00", formatter);
	}

	// Getters et setters pour texte et dateEvent
	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public LocalDateTime getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDateTime dateEvent) {
		this.dateEvent = dateEvent;
	}
}
