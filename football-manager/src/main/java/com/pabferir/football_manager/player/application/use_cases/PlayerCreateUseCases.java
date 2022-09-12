package com.pabferir.football_manager.player.application.use_cases;

import com.pabferir.football_manager.player.application.ports.in.PlayerCreateService;
import com.pabferir.football_manager.player.application.ports.out.PlayerPersistService;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.football_manager.player.domain.PlayerAggregateBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerCreateUseCases implements PlayerCreateService {
    private final PlayerPersistService playerPersistService;

    @Override
    public PlayerAggregate create(String firstName,
                                  String lastName,
                                  LocalDate dateOfBirth,
                                  Double height,
                                  String countryOfNationality,
                                  Integer jerseyNumber,
                                  String playerPositionName,
                                  Double currentValueInMillions,
                                  LocalDate lastValueUpdate) {
        log.info("Invoked 'add' method from " + this.getClass().getSimpleName() + "...");
        PlayerAggregate player = new PlayerAggregateBuilder()
                .forPlayer(firstName, lastName, dateOfBirth, height)
                .withCountryName(countryOfNationality)
                .withJerseyNumber(jerseyNumber)
                .withPositionName(playerPositionName)
                .withMarketValue(currentValueInMillions, lastValueUpdate)
                .build();
        PlayerAggregate result;
        try {
            result = playerPersistService.insert(player);
        } catch (Exception ex) {
            log.error("Could not create player " + lastName + ", " + firstName, ex);
            throw ex;
        }
        log.info("Player with id [" + result.getId() + "] added successfully");

        return result;
    }
}
