package mk.ukim.finki.wp.lab.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Album {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String genre;
    private int releaseYear;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
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
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
