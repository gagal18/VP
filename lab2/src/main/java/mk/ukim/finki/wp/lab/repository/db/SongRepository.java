package mk.ukim.finki.wp.lab.repository.db;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.enumerations.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTrackId(String trackId);
    List<Song> findByTitleOrGenre(String title, Genre genre);


}