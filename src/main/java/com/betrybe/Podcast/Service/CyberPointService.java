package com.betrybe.Podcast.Service;

import com.betrybe.Podcast.Model.CyberPoint;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CyberPointService {
    public CyberPoint findCyberById(Long id) {
        CyberPoint cyberPoint = new CyberPoint();

        cyberPoint.setId(id);
        cyberPoint.setName("Cyber Point");
        cyberPoint.setUrl("http://cyberpointrs.com.br");

        return cyberPoint;
    }

    public CyberPoint saveCyber(CyberPoint cyberPoint) {
        CyberPoint savedCyber = new CyberPoint();

        savedCyber.setId(new Random().nextLong(0, 1000));
        savedCyber.setName(cyberPoint.getName());
        savedCyber.setUrl(cyberPoint.getUrl());

        return savedCyber;
    }
}
