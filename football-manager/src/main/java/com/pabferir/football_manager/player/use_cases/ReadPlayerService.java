package com.pabferir.football_manager.player.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.use_cases.converters.PlayerMapper;
import com.pabferir.football_manager.player.use_cases.interfaces.repository.PlayerRepository;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadPlayerService implements com.pabferir.football_manager.player.use_cases.interfaces.services.ReadPlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Autowired
    public ReadPlayerService(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerDTO> getAll() {
        List<Player> players = playerRepository.findAll();

        return players.stream()
                .map(playerMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Could not find player with id [" + id + "] in the Database."));

        return playerMapper.entityToDTO(player);
    }

    @Override
    public List<PlayerDTO> getByCountry(String countryName) {
        CountryCode countryCode = CountryCode.findByName("(?i).*" + countryName + ".*").get(0);
        List<Player> players = new ArrayList<>(
                playerRepository.findByCountry(countryCode.getAlpha2()));

        return players.stream()
                .map(playerMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
