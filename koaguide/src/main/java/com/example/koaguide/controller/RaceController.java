package com.example.koaguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.koaguide.model.dto.RaceDto;
import com.example.koaguide.model.entity.Race;
import com.example.koaguide.service.RaceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/races")
public class RaceController {

    private final RaceService raceService;

      @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    // This controller will handle requests related
    @GetMapping("/id/{id}")
    public RaceDto getRaceById(@PathVariable Long id) {
        // Logic
        Race race = raceService.findRaceById(id);
        if (race == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Race with ID " + id + " not found.");
        }
        return toDTO(race);
    }

    @GetMapping("/name/{name}")
    public RaceDto getRaceByName(@PathVariable String name) {
        // Logic
        Race race = raceService.findRaceByName(name);
        if (race == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Race " + name + " not found.");
        }
        return toDTO(race);    
    }

    private RaceDto toDTO(Race race) {
        return new RaceDto(
            race.getId(),
            race.getName(),
            race.getDescription(),
            race.getFlagUrl(),
            race.getMaxAttUrl(),
            race.getClothingUrl()
        );
    }

    @GetMapping("/all")
    public List<RaceDto> getAllRaces() {
        return raceService.findAllRaces().stream()
            .map(this::toDTO)
            .toList();
    }
}


