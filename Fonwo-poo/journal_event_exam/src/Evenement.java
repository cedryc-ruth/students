import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evenement {
    protected String texte;
    protected LocalDateTime dateEvent;

    public Evenement(String texte, String dateTimeEvent) {
        this.texte = texte;
        this.dateEvent = LocalDateTime.parse(dateTimeEvent);
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
    public String toString(){
        return "texte";
    }
}
