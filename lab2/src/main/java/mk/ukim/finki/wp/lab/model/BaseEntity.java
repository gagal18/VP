package mk.ukim.finki.wp.lab.model;

import lombok.Getter;
import java.util.Random;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class BaseEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Random rd = new Random();
}
