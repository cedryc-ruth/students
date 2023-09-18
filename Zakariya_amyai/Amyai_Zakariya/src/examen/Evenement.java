package examen;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evenement {
	private String texte;
	private LocalTime dateEvent ;
	
	public Evenement(String texte , LocalTime dateEvent) {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public LocalTime getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalTime dateEvent) {
		this.dateEvent = dateEvent;
	}

}
