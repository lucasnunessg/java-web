package com.betrybe.Podcast.controller;

import com.betrybe.Podcast.Model.CyberPoint;
import com.betrybe.Podcast.Model.CyberPointCreationDto;
import com.betrybe.Podcast.Model.CyberPointDto;
import com.betrybe.Podcast.Service.CyberPointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cyber-point")
public class CyberPointController {

    private final CyberPointService service;

    public CyberPointController(CyberPointService service) {
        this.service = service;
    }

    @GetMapping
    public String getCyber() {
        return "Cyber Point Lan House";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CyberPointDto> getCyber(@PathVariable Long id) {

        if(id > 1000) {
            return ResponseEntity.notFound().build();
        }

        CyberPoint cyberPoint = service.findCyberById(id);

        CyberPointDto cyberPointDto = new CyberPointDto(
                cyberPoint.getId(), cyberPoint.getName(), cyberPoint.getUrl()
        );

                return ResponseEntity.ok(cyberPointDto);

    }

    @PostMapping
    public ResponseEntity<CyberPointDto> createCyber(@RequestBody CyberPointCreationDto cyberPointCreationDto) {
        CyberPoint newCyber = new CyberPoint();
        newCyber.setName(cyberPointCreationDto.name());
        newCyber.setUrl(cyberPointCreationDto.url());

        CyberPoint saveCyber = service.saveCyber(newCyber);

        CyberPointDto cyberPointDto = new CyberPointDto(
                saveCyber.getId(),
                saveCyber.getName(),
                saveCyber.getUrl()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(cyberPointDto);
    }

    @GetMapping("/search")
    public String searchCyber(@RequestParam String title) {
        return "Vc buscou pela loja: %s".formatted(title);
    }


}
