package mk.ukim.finki.wp.lab.repository.db;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}