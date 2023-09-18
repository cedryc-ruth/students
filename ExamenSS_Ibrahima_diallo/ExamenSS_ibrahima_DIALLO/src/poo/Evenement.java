package poo;

import java.time.LocalDateTime;

public class Evenement {
	private String texte;
	private LocalDateTime dateEvent;
	
	public Evenement(String texte, LocalDateTime localDateTime) {
		super();
		this.texte = texte;
		this.dateEvent = localDateTime;
	}

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

	@Override
	public String toString() {
		return "Evenement [texte=" + texte + ", dateEvent=" + dateEvent + "]";
	}
	
	
}
