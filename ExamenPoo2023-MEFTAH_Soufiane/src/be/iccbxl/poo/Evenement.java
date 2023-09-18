package be.iccbxl.poo;

import java.util.Date;

public class Evenement {
	
	private String texte;
	private Date dateEvent;
	public Evenement(String texte, Date dateEvent) {
		super();
		this.texte = texte;
		this.dateEvent = dateEvent;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	
	

}
