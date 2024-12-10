package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Artist {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String bio;
    @ManyToMany()
    private List<Song> songs;

    public Artist(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.songs = new ArrayList<>();
    }
    public void addSong(Song song) {
        System.out.println(song);
        if (song != null) {
            songs.add(song);
        }
    }
}
