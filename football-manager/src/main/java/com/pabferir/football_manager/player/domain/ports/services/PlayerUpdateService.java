package com.pabferir.football_manager.player.domain.ports.services;

import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;

import java.time.LocalDate;

public interface PlayerUpdateService {

    PlayerResponse update(
            Long id,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
            Double marketValue);
}
