package com.pabferir.football_manager.player.use_cases;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.interfaces.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPlayerByIdService {

    private final PlayerRepository playerRepository;

    @Autowired
    public GetPlayerByIdService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Could not find player with id [" + id + "] in the Database."));
    }
}
