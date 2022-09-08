package com.pabferir.web_api.controllers.player.dtos;

import java.time.LocalDate;

public class PlayerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer age;
    private Double height;
    private String nationality;
    private Integer jerseyNumber;
    private String playerPosition;
    private Double marketValueInMillions;

    public PlayerDTO() {
    }

    public PlayerDTO(
            Long id,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Integer age,
            Double height,
            String nationality,
            Integer jerseyNumber,
            String playerPosition,
            Double marketValueInMillions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.height = height;
        this.nationality = nationality;
        this.jerseyNumber = jerseyNumber;
        this.playerPosition = playerPosition;
        this.marketValueInMillions = marketValueInMillions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Double getMarketValueInMillions() {
        return marketValueInMillions;
    }

    public void setMarketValueInMillions(Double marketValueInMillions) {
        this.marketValueInMillions = marketValueInMillions;
    }
}
