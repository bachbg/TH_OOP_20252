package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    // ... Các thuộc tính và constructor giữ nguyên ...

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD: " + this.getTitle() + " has a length of 0 or less!");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}