package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private ArrayList<Track> tracks = new ArrayList<>();

    // ... Các phương thức khác giữ nguyên ...

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD: " + this.getTitle() + " has an empty or invalid total length!");
        }
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        
        // Duyệt qua danh sách track và xử lý lỗi
        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                // Ném tiếp ngoại lệ lên tầng giao diện xử lý kèm theo nguyên nhân (cause)
                throw new PlayerException("ERROR: CD Playback failed at track: " + track.getTitle(), e);
            }
        }
    }
}