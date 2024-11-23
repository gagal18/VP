package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    @Autowired
    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        List<Song> songs = songService.findAllSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("albums", albumService.findAll());
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "listSongs";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear) {
        Song song = new Song(title, genre, releaseYear);
        songService.addSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Optional<Song> song = songService.findSongById(songId);
        List<Album> albums = albumService.findAll();
        model.addAttribute("song", song);
        model.addAttribute("albums", albums);
        return "editSong";
    }
    @GetMapping("/add-song")
    public String addSong(Model model) {
        List<Album> albums = albumService.findAll();

        model.addAttribute("albums", albums);

        return "add-song";
    }


    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
