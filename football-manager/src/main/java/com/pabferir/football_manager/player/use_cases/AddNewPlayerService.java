package com.pabferir.football_manager.player.use_cases;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.interfaces.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewPlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public AddNewPlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addNew(Player player) {
        return playerRepository.save(player);
    }
}
