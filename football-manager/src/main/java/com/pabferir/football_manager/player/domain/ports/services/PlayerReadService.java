package com.pabferir.football_manager.player.domain.ports.services;

import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;

import java.util.List;

public interface PlayerReadService {

    List<PlayerResponse> getAll();

    PlayerResponse getById(Long id);

    List<PlayerResponse> getByCountry(String countryName);
}
