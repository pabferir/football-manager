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

        //TODO move validation logic to Request Validator?
//        if (firstName != null &&
//                firstName.length() > 0 &&
//                !Objects.equals(player.getFirstName(), firstName)) {
//            log.info("Updating Player.firstName from " + player.getFirstName() +
//                    " to " + firstName + "...");
//            player.setFirstName(firstName);
//        }
//
//        if (lastName != null &&
//                lastName.length() > 0 &&
//                !Objects.equals(player.getLastName(), lastName)) {
//            log.info("Updating Player.lastName from " + player.getLastName() +
//                    " to " + lastName + "...");
//            player.setLastName(lastName);
//        }
//
//        if (dateOfBirth != null &&
//                !dateOfBirth.isAfter(LocalDate.now()) &&
//                !dateOfBirth.isEqual(player.getDateOfBirth())) {
//            log.info("Updating Player.dateOfBirth from " + player.getDateOfBirth() +
//                    " to " + dateOfBirth + "...");
//            player.setDateOfBirth(dateOfBirth);
//        }
//
//        if (height != null &&
//                !height.equals(0.0) &&
//                !Objects.equals(height, player.getHeight())) {
//            log.info("Updating Player.height from " + player.getHeight() +
//                    " to " + height + "...");
//            player.setHeight(height);
//        }
//
//        if (countryOfNationality != null &&
//                countryOfNationality.length() > 0 &&
//                !Objects.equals(countryOfNationality, player.getNationality().getName())) {
//            log.info("Updating Player.nationality from " + player.getNationalityCountryName() +
//                    " to " + countryOfNationality + "...");
//            player.setNationality(CountryCode.findByName(countryOfNationality).get(0));
//        }
//
//        if (jerseyNumber != null &&
//                jerseyNumber < 100 &&
//                !Objects.equals(jerseyNumber, player.getJerseyNumber())) {
//            log.info("Updating Player.jerseyNumber from " + player.getJerseyNumber() +
//                    " to " + jerseyNumber + "...");
//            player.setJerseyNumber(jerseyNumber);
//        }
//
//        if (playerPositionName != null &&
//                playerPositionName.length() > 0 &&
//                !Objects.equals(playerPositionName, player.getPlayerPosition().getName())) {
//            log.info("Updating Player.position from " + player.getPlayerPositionName() +
//                    " to " + playerPositionName + "...");
//            player.setPlayerPosition(PlayerPosition.findByPositionName(playerPositionName));
//        }
//
//        if (marketValueInMillions != null &&
//                !marketValueInMillions.equals(0.0) &&
//                !Objects.equals(marketValueInMillions, player.getMarketValueInMillions())) {
//            log.info("Updating Player.marketValueInMillions from " + player.getMarketValueInMillions() +
//                    " to " + marketValueInMillions + "...");
//            player.setMarketValueInMillions(marketValueInMillions);
//        }
//
//        log.info("Player with id [" + player.getId() + "] updated successfully");
//
//        return player;
    }
}
