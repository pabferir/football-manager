package com.pabferir.football_manager.player.application.ports.in;

import com.pabferir.football_manager.player.domain.PlayerAggregate;

import java.time.LocalDate;

public interface PlayerCreateService {
    PlayerAggregate create(String firstName,
                           String lastName,
                           LocalDate dateOfBirth,
                           Double height,
                           String countryOfNationality,
                           Integer jerseyNumber,
                           String playerPositionName,
                           Double currentValueInMillions,
                           LocalDate lastValueUpdate);
}
