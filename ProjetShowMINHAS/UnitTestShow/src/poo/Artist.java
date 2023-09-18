package poo;

public class Artist {
	
	private String pseudo;
	private String fistname;
	private String lastname;
	private Style style;
	
	
	public Artist(String pseudo, String fistname, String lastname, Style style) {
		super();
		this.pseudo = pseudo;
		this.fistname = fistname;
		this.lastname = lastname;
		this.style = style;
	}
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "Artist [pseudo=" + pseudo + ", fistname=" + fistname + ", lastname=" + lastname + ", style=" + style
				+ "]";
	}
	
	
	

	
}
