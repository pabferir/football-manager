package com.pabferir.football_manager.player.application.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import com.pabferir.football_manager.player.application.converters.PlayerMapper;
import com.pabferir.football_manager.player.domain.ports.repository.PlayerRepository;
import com.pabferir.football_manager.player.domain.ports.services.PlayerCreateService;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerCreate implements PlayerCreateService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Override
    public PlayerResponse create(
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
            Double marketValueInMillions) {
        log.info("Invoked 'add' method from " + this.getClass().getSimpleName() + "...");
        Player player;
        try {
            player = playerRepository.save(new Player(
                    firstName,
                    lastName,
                    dateOfBirth,
                    height,
                    CountryCode.findByName(countryOfNationality).get(0),
                    jerseyNumber,
                    PlayerPosition.findByPositionName(playerPositionName),
                    marketValueInMillions));
        } catch (Exception ex) {
            log.error("Could not create player " + lastName + ", " + firstName, ex);
            throw ex;
        }
        log.info("Player with id [" + player.getId() + "] added successfully");
        //TODO service layer should not know about a Response object
        return playerMapper.entityToDTO(player);
    }
}
