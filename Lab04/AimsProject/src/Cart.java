import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {

    private ArrayList<Media> itemsOrdered =
            new ArrayList<>();

    public void addMedia(Media media) {

        if (!itemsOrdered.contains(media)) {

            itemsOrdered.add(media);

            System.out.println(
                    media.getTitle()
                    + " added to cart"
            );
        }
    }

    public void removeMedia(Media media) {

        if (itemsOrdered.contains(media)) {

            itemsOrdered.remove(media);

            System.out.println(
                    media.getTitle()
                    + " removed from cart"
            );
        }
    }

    public float totalCost() {

        float total = 0;

        for (Media media : itemsOrdered) {
            total += media.getCost();
        }

        return total;
    }

    public void printCart() {

        System.out.println("===== CART =====");

        for (Media media : itemsOrdered) {
            System.out.println(media);
        }

        System.out.println(
                "Total cost: "
                + totalCost()
                + "$"
        );
    }

    public void sortByTitle() {

        Collections.sort(
                itemsOrdered,
                Comparator.comparing(Media::getTitle)
                        .thenComparing(
                                Media::getCost,
                                Comparator.reverseOrder()
                        )
        );
    }

    public void sortByCost() {

        Collections.sort(
                itemsOrdered,
                Comparator.comparing(
                        Media::getCost,
                        Comparator.reverseOrder()
                ).thenComparing(Media::getTitle)
        );
    }
}
