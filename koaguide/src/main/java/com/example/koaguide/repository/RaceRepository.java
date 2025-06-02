package com.example.koaguide.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.koaguide.model.entity.Race;

public interface RaceRepository extends JpaRepository<Race, Long>{
    public List<Race> findAll(); 
   
    @Query("SELECT r from Race r where r.name = :name")
    public Optional<Race> findByName(@Param("name") String name);     
}