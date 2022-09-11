package com.pabferir.web_api.controllers.player.dtos;

import java.time.LocalDate;

public record PlayerResponse(Long id,
                             String firstName,
                             String lastName,
                             LocalDate dateOfBirth,
                             Integer age,
                             Double height,
                             String countryOfNationality,
                             Integer jerseyNumber,
                             String playerPositionName,
                             Double currentValueInMillions,
                             LocalDate lastValueUpdate) {
}
