package com.betrybe.Podcast.controller;

import com.betrybe.Podcast.Model.Podcast;
import com.betrybe.Podcast.Model.PodcastCreationDto;
import com.betrybe.Podcast.Model.PodcastDto;
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
    public ResponseEntity<PodcastDto> getPodcast(@PathVariable Long id) {

        if (id > 1000) {
            return ResponseEntity.notFound().build();
        }

        Podcast podcast = service.findPodcastById(id);

        PodcastDto podcastDto = new PodcastDto(
                podcast.getId(), podcast.getName(), podcast.getUrl()
        );

        return ResponseEntity.ok(podcastDto);

    }

    @PostMapping
    public ResponseEntity<PodcastDto> createPodcast(@RequestBody PodcastCreationDto podcastCreationDto) {
        Podcast newPodcast = new Podcast();
        newPodcast.setName(podcastCreationDto.name());
        newPodcast.setUrl(podcastCreationDto.url());

        Podcast savedPodcast = service.savePodcast(newPodcast);

        PodcastDto podcastDto = new PodcastDto(
                savedPodcast.getId(),
                savedPodcast.getName(),
                savedPodcast.getUrl()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(podcastDto);
    }
}
