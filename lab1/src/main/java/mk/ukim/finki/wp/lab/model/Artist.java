package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    Random rd = new Random();

    public Artist(String firstName, String lastName, String bio) {
        this.id = Math.abs(rd.nextLong());
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
