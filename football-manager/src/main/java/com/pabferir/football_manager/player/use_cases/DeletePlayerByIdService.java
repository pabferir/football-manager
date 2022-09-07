package com.pabferir.football_manager.player.use_cases;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.interfaces.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePlayerByIdService {

    private final PlayerRepository playerRepository;

    @Autowired
    public DeletePlayerByIdService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player deleteById(Long id) throws IllegalStateException {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Couldn't find Player with id [" + id + "] in the Database."));

        playerRepository.deleteById(id);
        return player;
    }
}
