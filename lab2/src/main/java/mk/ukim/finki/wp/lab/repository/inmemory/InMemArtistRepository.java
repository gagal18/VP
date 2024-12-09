package mk.ukim.finki.wp.lab.repository.inmemory;
import mk.ukim.finki.wp.lab.bootstrap.DataInit;
import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemArtistRepository {
    public List<Artist> findAll() {
        return DataInit.artists;
    }
    public Optional<Artist> findById(Long id) {
        return DataInit.artists.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
