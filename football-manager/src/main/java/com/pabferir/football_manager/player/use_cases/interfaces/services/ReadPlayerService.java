package com.pabferir.football_manager.player.use_cases.interfaces.services;

import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;

import java.util.Collection;

public interface ReadPlayerService {

    Collection<PlayerDTO> getAll();

    PlayerDTO getById(Long id);

    Collection<PlayerDTO> getByCountry(String countryName);
}
