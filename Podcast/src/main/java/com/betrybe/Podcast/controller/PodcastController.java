package com.betrybe.Podcast.controller;

import com.betrybe.Podcast.Model.Podcast;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

    @GetMapping
    public String getRoot() {
        return "Yay Podcasts!";
    }

    @GetMapping("/{id}")
    public Podcast getPodcast(@PathVariable Long id) {
        Podcast podcast = new Podcast();
        podcast.setId(id);
        podcast.setName("Meu podcast");
        podcast.setContent("O melhor podcast do mundo!");
        podcast.setUrl("http://www.meupodcast.com.br");
        return podcast;
       // return "Você pediu pelo Podcast com id: %d".formatted(id); // "%d" indica que será um inteiro
    }

    @GetMapping("/search")
    public String searchPodcast(@RequestParam String title) {
        return "Você buscou por Podcasts com o título: %s".formatted(title); // "%s" indica que será uma string
    }
   // http://localhost:8080/podcasts/search?title=podcasts a pesquisa fica assim
}