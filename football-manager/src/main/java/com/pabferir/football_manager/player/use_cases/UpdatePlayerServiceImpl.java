package com.pabferir.football_manager.player.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import com.pabferir.football_manager.player.use_cases.interfaces.repository.PlayerRepository;
import com.pabferir.football_manager.player.use_cases.converters.PlayerMapper;
import com.pabferir.football_manager.player.use_cases.interfaces.services.UpdatePlayerService;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class UpdatePlayerServiceImpl implements UpdatePlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Autowired
    public UpdatePlayerServiceImpl(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public PlayerDTO update(
            Long id,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            Double height,
            String countryOfNationality,
            Integer jerseyNumber,
            String playerPositionName,
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

        if (countryOfNationality != null &&
                countryOfNationality.length() > 0 &&
                !Objects.equals(countryOfNationality, player.getNationality().getName())) {
            player.setNationality(CountryCode.findByName(countryOfNationality).get(0));
        }

        if (jerseyNumber != null &&
                jerseyNumber < 100 &&
                !Objects.equals(jerseyNumber, player.getJerseyNumber())) {
            player.setJerseyNumber(jerseyNumber);
        }

        if (playerPositionName != null &&
                playerPositionName.length() > 0 &&
                !Objects.equals(playerPositionName, player.getPlayerPosition().getName())) {
            player.setPlayerPosition(PlayerPosition.findByPositionName(playerPositionName));
        }

        if (marketValue != null &&
                !marketValue.equals(0.0) &&
                !Objects.equals(marketValue, player.getMarketValueInMillions())) {
            player.setMarketValueInMillions(marketValue);
        }

        return playerMapper.entityToDTO(player);
    }
}
