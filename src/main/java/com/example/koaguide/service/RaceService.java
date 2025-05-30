package com.example.koaguide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.koaguide.model.entity.Race;
import com.example.koaguide.repository.RaceRepository;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public Race findRaceById(Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    public Race findRaceByName(String name) {

        return raceRepository.findByName(name).orElse(null);
    }

    public List<Race> findAllRaces() {
        List<Race> races = raceRepository.findAll();
        if (!races.isEmpty()) {
            for (Race race : races) {
                System.out.println("Race Name: " + race.getName() + "\n " + race.getDescription() + "\n\n ");
            }
        }
        return raceRepository.findAll();

    }
}
