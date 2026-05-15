import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore =
            new ArrayList<>();

    public void addMedia(Media media) {

        itemsInStore.add(media);

        System.out.println(
                media.getTitle()
                + " added to store"
        );
    }

    public void removeMedia(Media media) {

        itemsInStore.remove(media);

        System.out.println(
                media.getTitle()
                + " removed from store"
        );
    }

    public void showStore() {

        System.out.println("===== STORE =====");

        for (Media media : itemsInStore) {
            System.out.println(media);
        }
    }

    public Media searchMedia(String title) {

        for (Media media : itemsInStore) {

            if (media.getTitle()
                    .equalsIgnoreCase(title)) {

                return media;
            }
        }

        return null;
    }
}
