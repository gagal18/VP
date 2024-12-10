package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.enumerations.Genre;
import mk.ukim.finki.wp.lab.repository.db.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }
    public List<Song> findAllWithFilter(String filter) {
        return songRepository.findByTitleOrGenre(filter, Genre.valueOf(filter));
    }

    public Optional<Song> findSongByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
    public Optional<Song> findSongById(Long id) {
        return songRepository.findById(id);
    }


    public Artist addArtistToSong(Artist artist, String trackId) {
        Optional<Song> optionalSong = songRepository.findByTrackId(trackId);
        if (optionalSong.isPresent() && artist != null) {
            Song song = optionalSong.get();
            List<Artist> prev = song.getArtists();
            prev.add(artist);
            song.setArtists(prev);
            return artist;
        }
        return null;
    }

    public Song addSong(Song newSong) {
        songRepository.save(newSong);
        return newSong;
    }

    public boolean deleteSong(Long id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()) {
            songRepository.delete(song.get());
            return true;
        }
        return false;
    }
}
