package com.pabferir.football_manager.player.application.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.application.converters.PlayerMapper;
import com.pabferir.football_manager.player.domain.ports.repository.PlayerRepository;
import com.pabferir.football_manager.player.domain.ports.services.PlayerReadService;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerRead implements PlayerReadService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Override
    public List<PlayerResponse> getAll() {
        log.info("Invoked 'getAll()' method from " + this.getClass().getSimpleName() + "...");
        List<Player> players = playerRepository.findAll();
        log.info("All Player retrieved successfully");

        return players.stream()
                .map(playerMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerResponse getById(Long id) {
        log.info("Invoked 'getById(" + id + ")' method from " + this.getClass().getSimpleName() + "...");
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Could not find player with id [" + id + "] in the Database."));
        log.info("Player with id [" + player.getId() + "] retrieved successfully");

        return playerMapper.entityToDTO(player);
    }

    @Override
    public List<PlayerResponse> getByCountry(String countryName) {
        log.info("Invoked 'getByCountry(" + countryName + ")' method from " + this.getClass().getSimpleName() + "...");
        CountryCode countryCode = CountryCode.findByName("(?i).*" + countryName + ".*").get(0);
        List<Player> players = new ArrayList<>(
                playerRepository.findByCountry(countryCode.getAlpha2()));
        log.info("All Player from country " + countryName + " retrieved successfully");

        return players.stream()
                .map(playerMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
