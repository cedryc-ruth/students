import java.util.ArrayList;

public class Journal {
    private ArrayList<Show> shows;

    public Journal() {
        this.shows = new ArrayList<>();
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "shows=" + shows +
                '}';
    }
}
