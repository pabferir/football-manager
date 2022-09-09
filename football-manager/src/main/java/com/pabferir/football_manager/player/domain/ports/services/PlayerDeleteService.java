package com.pabferir.football_manager.player.domain.ports.services;

import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;

public interface PlayerDeleteService {

    PlayerResponse deleteById(Long id);
}
