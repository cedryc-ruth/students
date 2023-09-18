package poo;

import java.time.LocalDate;

public class Evenement {

	private String texte;
	private LocalDate dateEvent;
	
	
	public Evenement(String texte, LocalDate dateEvent) {
		super();
		this.texte = texte;
		this.dateEvent = dateEvent;
	}
	public Evenement(String string, String string2, double d) {
		// TODO Auto-generated constructor stubs
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
	@Override
	public String toString() {
		return "Evenement [texte=" + texte + ", dateEvent=" + dateEvent + "]";
	}
	

}
