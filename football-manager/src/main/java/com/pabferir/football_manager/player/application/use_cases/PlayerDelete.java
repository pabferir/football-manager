package com.pabferir.football_manager.player.application.use_cases;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.application.converters.PlayerMapper;
import com.pabferir.football_manager.player.domain.ports.repository.PlayerRepository;
import com.pabferir.football_manager.player.domain.ports.services.PlayerDeleteService;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerDelete implements PlayerDeleteService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Override
    public PlayerResponse deleteById(Long id) {
        log.info("Invoked 'deleteById' method from " + this.getClass().getSimpleName() + "...");
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Couldn't find Player with id [" + id + "] in the Database."));
        playerRepository.deleteById(id);
        log.info("Player with id [" + player.getId() + "] deleted successfully");

        return playerMapper.entityToDTO(player);
    }
}
