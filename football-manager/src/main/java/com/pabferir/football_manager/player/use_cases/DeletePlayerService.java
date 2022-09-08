package com.pabferir.football_manager.player.use_cases;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.use_cases.converters.PlayerMapper;
import com.pabferir.football_manager.player.use_cases.interfaces.repository.PlayerRepository;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePlayerService implements com.pabferir.football_manager.player.use_cases.interfaces.services.DeletePlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Autowired
    public DeletePlayerService(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO deleteById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Couldn't find Player with id [" + id + "] in the Database."));
        playerRepository.deleteById(id);

        return playerMapper.entityToDTO(player);
    }
}
