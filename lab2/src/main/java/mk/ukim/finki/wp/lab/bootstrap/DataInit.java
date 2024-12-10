package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.enumerations.Genre;
import mk.ukim.finki.wp.lab.repository.db.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.db.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.db.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public DataInit(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }


    @PostConstruct
    public void init(){
        artists = new ArrayList<Artist>();
        songs = new ArrayList<Song>();
        albums = new ArrayList<>();
        if (this.songRepository.count() == 0) {
            // Initializing Songs
            songs.add(new Song("The Joker", Genre.TECHNO, 2024));
            songs.add(new Song("Lost in the Groove", Genre.TECHNO, 2023));
            songs.add(new Song("Pictures of You", Genre.RAP, 2022));
            songs.add(new Song("Follow", Genre.ROCK, 2020));
            songs.add(new Song("Doppler", Genre.TECHNO, 2021));
            songRepository.saveAll(songs);
        }
        if (this.albumRepository.count() == 0) {
            // Initializing Albums
            albums.add(new Album("Techno Dreams", "Techno", 2024));
            albums.add(new Album("Groove Chronicles", "Deep House", 2023));
            albums.add(new Album("Mystic Waves", "Melodic Techno", 2022));
            albums.add(new Album("Electronic Pulse", "Electronic", 2021));
            albums.add(new Album("Deep Connections", "Techno", 2023));
            albumRepository.saveAll(albums);
        }
        if (this.artistRepository.count() == 0) {
            // Initializing Artists
            artists.add(new Artist("Boris", "Brejcha", "A techno innovator known for his deep beats and dramatic flair, captivating audiences worldwide."));
            artists.add(new Artist("Argy", "Argy", "A Greek artist blending deep grooves and atmospheric soundscapes, creating a unique take on house and techno."));
            artists.add(new Artist("Anyma", "", "An enigmatic artist who fuses melodic house with ethereal vocals for hauntingly beautiful tracks."));
            artists.add(new Artist("Charlotte de", "Witte", "techno force of nature from Belgium. With her distinct sound, she is at the frontline of the global electronic music scene."));
            artists.add(new Artist("Amelie", "Lens", "A powerhouse DJ and producer, Amelie energizes the dance floor with her intense and melodic techno beats."));
            this.artistRepository.saveAll(artists);
        }
    }
}
