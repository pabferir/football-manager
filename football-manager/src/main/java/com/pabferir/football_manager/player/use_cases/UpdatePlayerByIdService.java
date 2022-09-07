package com.pabferir.football_manager.player.use_cases;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.enums.Nationality;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import com.pabferir.football_manager.player.domain.interfaces.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class UpdatePlayerByIdService {

    private final PlayerRepository playerRepository;

    @Autowired
    public UpdatePlayerByIdService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player updateById(
            Long id,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            Integer jerseyNumber,
            PlayerPosition playerPosition,
            Nationality nationality,
            Double marketValue) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Couldn't find Player with id [" + id + "] in the Database."));

        //TODO move validation logic to Request Validator
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(player.getFirstName(), firstName)) {
            player.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(player.getLastName(), lastName)) {
            player.setLastName(lastName);
        }

        if (dateOfBirth != null &&
                !dateOfBirth.isAfter(LocalDate.now()) &&
                !dateOfBirth.isEqual(player.getDateOfBirth())) {
            player.setDateOfBirth(dateOfBirth);
        }

        if (height != null &&
                !height.equals(0.0) &&
                !Objects.equals(height, player.getHeight())) {
            player.setHeight(height);
        }

        if (jerseyNumber != null &&
                jerseyNumber < 100 &&
                !Objects.equals(jerseyNumber, player.getJerseyNumber())) {
            player.setJerseyNumber(jerseyNumber);
        }

        if (playerPosition != null &&
                !Objects.equals(playerPosition, player.getPlayerPosition())) {
            player.setPlayerPosition(playerPosition);
        }

        if (nationality != null &&
                !Objects.equals(nationality, player.getNationality())) {
            player.setNationality(nationality);
        }

        if (marketValue != null &&
                !marketValue.equals(0.0) &&
                !Objects.equals(marketValue, player.getMarketValue())) {
            player.setMarketValue(marketValue);
        }

        return player;
    }
}
