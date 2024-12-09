package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.inmemory.InMemArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final InMemArtistRepository inMemArtistRepository;

    public ArtistService(InMemArtistRepository inMemArtistRepository) {
        this.inMemArtistRepository = inMemArtistRepository;
    }

    public List<Artist> findAllArtists() {
        return inMemArtistRepository.findAll();
    }

    public Optional<Artist> findArtistById(Long id) {
        return inMemArtistRepository.findById(id);
    }
}
