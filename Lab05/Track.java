package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    // ... Các thuộc tính giữ nguyên ...

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track: " + this.getTitle() + " has a length of 0 or less!");
        }
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}