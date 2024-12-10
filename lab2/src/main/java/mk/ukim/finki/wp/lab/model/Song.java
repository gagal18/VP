package mk.ukim.finki.wp.lab.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.model.enumerations.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Getter
public class Song {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String trackId;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int releaseYear;
    @ManyToMany()
    private List<Artist> artists;
    @ManyToOne
    private Album album;

    public Song(String title, Genre genre, int releaseYear){
        this.trackId = UUID.randomUUID().toString();
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.artists = new ArrayList<>();
    }

    public void addPerformer(Artist artist) {
        if (artist != null) {
            artists.add(artist);
        }
    }
    public void addSongToAlbum(Album album) {
        if (album != null) {
            this.album = album;
        }
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + getAlbum() + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
