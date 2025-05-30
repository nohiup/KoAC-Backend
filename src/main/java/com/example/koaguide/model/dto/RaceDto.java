package com.example.koaguide.model.dto;


public class RaceDto{
    private Long id;
    private String name;
    private String description;
    private String flagUrl;
    private String maxAttUrl;
    private String clothingUrl;

    public RaceDto(Long id, String name, String description, String flagUrl, String maxAttUrl, String clothingUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.flagUrl = flagUrl;
        this.maxAttUrl = maxAttUrl;
        this.clothingUrl = clothingUrl;
    }

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