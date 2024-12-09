package mk.ukim.finki.wp.lab.model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Album extends BaseEntity {
    private String title;
    private String genre;
    private int releaseYear;

    @OneToMany(mappedBy = "id")
    private List<Song> songs;

    public Album(String title, String genre, int releaseYear){
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
            song.addSongToAlbum(this);
        }
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
