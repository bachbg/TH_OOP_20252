public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {

        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {

        if (length <= 0) {
            System.out.println("ERROR: Invalid track length");
            return;
        }

        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        return title.equalsIgnoreCase(other.title)
                && length == other.length;
    }
}
