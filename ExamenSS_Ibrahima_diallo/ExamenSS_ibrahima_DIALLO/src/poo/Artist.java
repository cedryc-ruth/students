package poo;

public class Artist {
	private String pseudo;
	private String firsname;
	private String lastname;
	private Style style;
	
	public Artist(String pseudo, String firsname, String lastname, Style style) {
		super();
		this.pseudo = pseudo;
		this.firsname = firsname;
		this.lastname = lastname;
		this.style = style;
	}
	

	public Artist(String firsname, String lastname) {
		super();
		this.firsname = firsname;
		this.lastname = lastname;
	}


	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getFirsname() {
		return firsname;
	}

	public void setFirsname(String firsname) {
		this.firsname = firsname;
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
		return "Artist [pseudo=" + pseudo + ", firsname=" + firsname + ", lastname=" + lastname + ", style=" + style
				+ "]";
	}
	
	

}
