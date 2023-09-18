package examen_poo_septembre2023;

import java.util.ArrayList;


public class Journal {
	
	private ArrayList<Evenement> events;
	
	
	

	public Journal(ArrayList<Evenement> events) {
		super();
		this.events = events;
	}

	public ArrayList<Evenement> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Evenement> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Journal [events=" + events + "]";
	}
	
}
