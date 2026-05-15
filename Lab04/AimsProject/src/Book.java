import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors =
            new ArrayList<>();

    public Book(int id,
                String title,
                String category,
                float cost) {

        super(id, title, category, cost);
    }

    public void addAuthor(String author) {

        if (!authors.contains(author)) {
            authors.add(author);
            System.out.println("Author added");
        }
    }

    public void removeAuthor(String author) {

        if (authors.contains(author)) {
            authors.remove(author);
            System.out.println("Author removed");
        }
    }

    @Override
    public String toString() {

        return "Book - "
                + title
                + " - "
                + category
                + " - "
                + cost
                + "$";
    }
}
