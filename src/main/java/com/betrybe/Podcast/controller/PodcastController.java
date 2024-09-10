package com.betrybe.Podcast.controller;

import com.betrybe.Podcast.Model.Podcast;
import com.betrybe.Podcast.Service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

    private final PodcastService service;

    @Autowired
    public PodcastController(PodcastService service) {
        this.service = service;
    }

    @GetMapping
    public String getRoot() {
        return "Yay Podcasts!";
    }

    @GetMapping("/search")
    public String searchPodcast(@RequestParam String title) {
        return "Você buscou por Podcasts com o título: %s".formatted(title); // "%s" indica que será uma string
    }

    @GetMapping("/{id}")
    public ResponseEntity<Podcast> findPodcastById(@PathVariable Long id) {

        if (id > 1000) {
            return ResponseEntity.notFound().build();
        }

        Podcast podcast = service.findPodcastById(id);

        return ResponseEntity.ok(podcast);

    }

    @PostMapping
    public ResponseEntity<Podcast> createPodcast(@RequestBody Podcast newPodcast) {
        Podcast savedPodcast = service.savePodcast(newPodcast);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPodcast);
    }
}
