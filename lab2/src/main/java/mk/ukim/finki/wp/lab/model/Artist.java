package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Artist extends BaseEntity {
    private String firstName;
    private String lastName;
    private String bio;
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
