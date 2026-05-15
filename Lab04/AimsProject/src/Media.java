public abstract class Media {

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media(int id, String title,
                 String category, float cost) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;

        return this.title.equalsIgnoreCase(other.title);
    }

    @Override
    public String toString() {

        return "Media: "
                + title
                + " - "
                + category
                + " - "
                + cost
                + "$";
    }
}
