package com.pabferir.web_api.controllers.player.dtos;

import java.time.LocalDate;

public record UpdatePlayerRequest(String firstName,
                                  String lastName,
                                  LocalDate dateOfBirth,
                                  Double height,
                                  String countryOfNationality,
                                  Integer jerseyNumber,
                                  String playerPositionName,
                                  Double currentValueInMillions,
                                  LocalDate lastValueUpdate) {
}
