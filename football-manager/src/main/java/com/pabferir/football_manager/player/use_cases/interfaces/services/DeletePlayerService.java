package com.pabferir.football_manager.player.use_cases.interfaces.services;

import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;

public interface DeletePlayerService {

    PlayerDTO deleteById(Long id);
}
