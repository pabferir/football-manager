package com.pabferir.football_manager.player.application.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import com.pabferir.football_manager.player.application.converters.PlayerMapper;
import com.pabferir.football_manager.player.domain.ports.repository.PlayerRepository;
import com.pabferir.football_manager.player.domain.ports.services.PlayerUpdateService;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerUpdate implements PlayerUpdateService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Override
    @Transactional
    public PlayerResponse update(
            Long id,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
            Double marketValueInMillions) {
        log.info("Invoked 'update' method from " + this.getClass().getSimpleName() + "...");
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Couldn't find Player with id [" + id + "] in the Database."));

        //TODO move validation logic to Request Validator
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(player.getFirstName(), firstName)) {
            log.info("Updating Player.firstName from " + player.getFirstName() + " to " + firstName + "...");
            player.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(player.getLastName(), lastName)) {
            log.info("Updating Player.lastName from " + player.getLastName() + " to " + lastName + "...");
            player.setLastName(lastName);
        }

        if (dateOfBirth != null &&
                !dateOfBirth.isAfter(LocalDate.now()) &&
                !dateOfBirth.isEqual(player.getDateOfBirth())) {
            log.info("Updating Player.dateOfBirth from " + player.getDateOfBirth() + " to " + dateOfBirth + "...");
            player.setDateOfBirth(dateOfBirth);
        }

        if (height != null &&
                !height.equals(0.0) &&
                !Objects.equals(height, player.getHeight())) {
            log.info("Updating Player.height from " + player.getHeight() + " to " + height + "...");
            player.setHeight(height);
        }

        if (countryOfNationality != null &&
                countryOfNationality.length() > 0 &&
                !Objects.equals(countryOfNationality, player.getNationality().getName())) {
            log.info("Updating Player.nationality from " + player.getNationalityCountryName() + " to " + countryOfNationality + "...");
            player.setNationality(CountryCode.findByName(countryOfNationality).get(0));
        }

        if (jerseyNumber != null &&
                jerseyNumber < 100 &&
                !Objects.equals(jerseyNumber, player.getJerseyNumber())) {
            log.info("Updating Player.jerseyNumber from " + player.getJerseyNumber() + " to " + jerseyNumber + "...");
            player.setJerseyNumber(jerseyNumber);
        }

        if (playerPositionName != null &&
                playerPositionName.length() > 0 &&
                !Objects.equals(playerPositionName, player.getPlayerPosition().getName())) {
            log.info("Updating Player.position from " + player.getPlayerPositionName() + " to " + playerPositionName + "...");
            player.setPlayerPosition(PlayerPosition.findByPositionName(playerPositionName));
        }

        if (marketValueInMillions != null &&
                !marketValueInMillions.equals(0.0) &&
                !Objects.equals(marketValueInMillions, player.getMarketValueInMillions())) {
            log.info("Updating Player.marketValueInMillions from " + player.getMarketValueInMillions() + " to " + marketValueInMillions + "...");
            player.setMarketValueInMillions(marketValueInMillions);
        }

        log.info("Player with id [" + player.getId() + "] updated successfully");

        return playerMapper.entityToDTO(player);
    }
}
