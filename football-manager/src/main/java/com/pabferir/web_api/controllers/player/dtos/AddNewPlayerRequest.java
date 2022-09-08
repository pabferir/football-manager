package com.pabferir.web_api.controllers.player.dtos;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AddNewPlayerRequest {
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Double height;
    private final String countryOfNationality;
    private final Integer jerseyNumber;
    private final String playerPositionName;
    private final Double marketValueInMillions;

    public AddNewPlayerRequest(
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
            Double marketValueInMillions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.countryOfNationality = countryOfNationality;
        this.jerseyNumber = jerseyNumber;
        this.playerPositionName = playerPositionName;
        this.marketValueInMillions = marketValueInMillions;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Double getHeight() {
        return height;
    }

    public String getCountryOfNationality() {
        return countryOfNationality;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public String getPlayerPositionName() {
        return playerPositionName;
    }

    public Double getMarketValueInMillions() {
        return marketValueInMillions;
    }
}
