import java.util.ArrayList;

public class CompactDisc
        extends Disc
        implements Playable {

    private String artist;

    private ArrayList<Track> tracks =
            new ArrayList<>();

    public CompactDisc(int id,
                       String title,
                       String category,
                       float cost,
                       int length,
                       String director,
                       String artist) {

        super(id, title, category,
                cost, length, director);

        this.artist = artist;
    }

    public void addTrack(Track track) {

        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    @Override
    public int getLength() {

        int total = 0;

        for (Track track : tracks) {
            total += track.getLength();
        }

        return total;
    }

    @Override
    public void play() {

        if (tracks.isEmpty()) {
            System.out.println("No track available");
            return;
        }

        System.out.println("Playing CD: " + title);

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {

        return "CD - "
                + title
                + " - "
                + artist
                + " - "
                + cost
                + "$";
    }
}
