package be.iccbxl.poo;

public class Artiste  {
	
	private String pseudo;
    private String firstname;
    private String lastname;
    private String style;
	private String artiste;
	public Artiste(String pseudo, String firstname, String lastname, String style) {
		super();
		this.pseudo = pseudo;
		this.firstname = firstname;
		this.lastname = lastname;
		this.style = style;
	}
	
	public Artiste(String artiste, String style) {
		this.artiste = artiste;
		this.style = style;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
    
    

}
