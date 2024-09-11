package com.betrybe.Podcast.Service;

import com.betrybe.Podcast.Model.Podcast;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Service

public class PodcastService {
    public Podcast findPodcastById(Long id) {
    Podcast podcast = new Podcast();

    podcast.setId(id);
    podcast.setName("Meu Podcast");
    podcast.setUrl("http://www.meupodcast.com.br");
    podcast.setContent("O melhor podcast do mundo!");

    podcast.setSecretToken("super-secret-token-123");


    return podcast;
    }



    public Podcast savePodcast(Podcast podcast) {
        Podcast savedPodcast = new Podcast();

        savedPodcast.setId(new Random().nextLong(0, 1000));
        savedPodcast.setName(podcast.getName());
        savedPodcast.setUrl(podcast.getUrl());
        savedPodcast.setContent(podcast.getContent());


        return savedPodcast;
    }


}
