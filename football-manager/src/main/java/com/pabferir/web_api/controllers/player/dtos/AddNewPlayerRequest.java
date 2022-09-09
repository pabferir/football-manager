package com.pabferir.web_api.controllers.player.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
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
}
