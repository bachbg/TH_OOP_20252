import java.util.Scanner;

public class Aims {

    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc(
                        1,
                        "Avengers",
                        "Action",
                        19.5f,
                        120,
                        "Marvel"
                );

        Book book1 =
                new Book(
                        2,
                        "Java Core",
                        "Education",
                        15.0f
                );

        CompactDisc cd1 =
                new CompactDisc(
                        3,
                        "Hits",
                        "Music",
                        20.0f,
                        60,
                        "Sony",
                        "Taylor"
                );

        cd1.addTrack(new Track("Song A", 4));
        cd1.addTrack(new Track("Song B", 5));

        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(cd1);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\nAIMS");
            System.out.println("1. View Store");
            System.out.println("2. View Cart");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    store.showStore();

                    System.out.println(
                            "Enter media title to add:"
                    );

                    String title =
                            scanner.nextLine();

                    Media found =
                            store.searchMedia(title);

                    if (found != null) {
                        cart.addMedia(found);
                    } else {
                        System.out.println(
                                "Media not found"
                        );
                    }

                    break;

                case 2:

                    cart.printCart();

                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}
