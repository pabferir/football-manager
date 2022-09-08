package com.pabferir.football_manager.player.use_cases.interfaces.services;

import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;

import java.time.LocalDate;

public interface CreatePlayerService {

    PlayerDTO add (
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
            Double marketValueInMillions);
}
