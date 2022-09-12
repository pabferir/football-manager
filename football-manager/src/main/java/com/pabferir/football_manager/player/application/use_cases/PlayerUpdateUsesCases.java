package com.pabferir.football_manager.player.application.use_cases;

import com.pabferir.football_manager.player.application.ports.in.PlayerUpdateService;
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
public class PlayerUpdateUsesCases implements PlayerUpdateService {
    private final PlayerPersistService playerPersistService;

    @Override
    public PlayerAggregate update(Long id,
                                  String firstName,
                                  String lastName,
                                  LocalDate dateOfBirth,
                                  Double height,
                                  String countryOfNationality,
                                  Integer jerseyNumber,
                                  String playerPositionName,
                                  Double currentValueInMillions,
                                  LocalDate lastValueUpdate) {
        log.info("Invoked 'update' method from " + this.getClass().getSimpleName() + "...");
        PlayerAggregate storedState = playerPersistService.selectById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Couldn't find Player with id [" + id + "] in the Database."));

        PlayerAggregate updatedState = new PlayerAggregateBuilder()
                .forPlayer(id, firstName, lastName, dateOfBirth, height)
                .withCountryName(countryOfNationality)
                .withJerseyNumber(jerseyNumber)
                .withPositionName(playerPositionName)
                .withMarketValue(currentValueInMillions, lastValueUpdate)
                .build();

        //TODO not detecting equal values
        if (updatedState.equals(storedState)) {
            log.error("Could not update Player with id [" + id + "]. Provided state and stored state are equals.");
            throw new IllegalArgumentException("Could not update Player with id [" + id + "]." +
                    "Provided new state and stored state are equals.");
        }
        log.info("Updating Player with id [" + id + "] from " + storedState.toString() +
                " to " + updatedState);
        PlayerAggregate result;
        try {
            result = playerPersistService.update(updatedState);
        } catch (Exception ex) {
            log.error("Could not update Player with id [" + id + "]", ex);
            throw ex;
        }
        log.info("Player with id [" + result.getId() + "] updated successfully");

        return result;
    }
}
