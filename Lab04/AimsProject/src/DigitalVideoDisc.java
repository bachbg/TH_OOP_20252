public class DigitalVideoDisc
        extends Disc
        implements Playable {

    public DigitalVideoDisc(int id,
                            String title,
                            String category,
                            float cost,
                            int length,
                            String director) {

        super(id, title, category,
                cost, length, director);
    }

    @Override
    public void play() {

        if (length <= 0) {
            System.out.println("ERROR: Invalid DVD length");
            return;
        }

        System.out.println("Playing DVD: " + title);
        System.out.println("DVD length: " + length);
    }

    @Override
    public String toString() {

        return "DVD - "
                + title
                + " - "
                + category
                + " - "
                + cost
                + "$";
    }
}
