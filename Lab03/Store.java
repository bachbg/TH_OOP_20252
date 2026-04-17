public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100000000];
    private int nbItemsInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        this.itemsInStore[this.nbItemsInStore] = dvd;
        this.nbItemsInStore++;
        System.out.println("Added dvd " + dvd.getTitle() + " to store");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < nbItemsInStore; i++) {
            if (dvd == itemsInStore[i]) {
                found = true;
                for (int j = i; j < nbItemsInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[nbItemsInStore - 1] = null;
                nbItemsInStore--;
                System.out.println("Removed dvd " + dvd.getTitle() + " from store");
                break;
            }
        }
        if (!found) {
            System.out.println("There is no dvd " + dvd.getTitle() + " in store");
        }
    }
}