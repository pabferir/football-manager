package com.pabferir.football_manager.player.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import com.pabferir.football_manager.player.use_cases.interfaces.repository.PlayerRepository;
import com.pabferir.football_manager.player.use_cases.converters.PlayerMapper;
import com.pabferir.football_manager.player.use_cases.interfaces.services.CreatePlayerService;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreatePlayerServiceImpl implements CreatePlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Autowired
    public CreatePlayerServiceImpl(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO add (
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
            Double marketValueInMillions) {
        Player player = playerRepository.save(
                new Player(
                        firstName,
                        lastName,
                        dateOfBirth,
                        height,
                        CountryCode.findByName(countryOfNationality).get(0),
                        jerseyNumber,
                        PlayerPosition.findByPositionName(playerPositionName),
                        marketValueInMillions));

        return playerMapper.entityToDTO(player);

    }
}
