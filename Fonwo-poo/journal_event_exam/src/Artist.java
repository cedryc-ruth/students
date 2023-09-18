public class Artist {
    private String pseudo;
    private String firstName;
    private String lastName;
    private Style style;

    public Artist(String pseudo, String firstName, String lastName, Style style) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.style = style;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "pseudo='" + pseudo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
