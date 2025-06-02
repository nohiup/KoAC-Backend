package com.example.koaguide.model.entity;

import org.springframework.boot.context.properties.bind.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "race")
public class Race{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "flag")
    private String flagUrl;

    @Column(name =  "max_attribute", nullable = false)
    private String maxAttUrl;

    @Column(name = "clothing")
    private String clothingUrl;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public String getMaxAttUrl() {
        return maxAttUrl;
    }

    public String getClothingUrl() {
        return clothingUrl;
    }
}
