package com.pabferir.football_manager.player.application.converters;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerMapper {

    private final ModelMapper modelMapper;

    public PlayerResponse entityToDTO(Player player) {
        return modelMapper.typeMap(Player.class, PlayerResponse.class)
                .addMapping(Player::getNationalityCountryName, PlayerResponse::setNationality)
                .addMapping(Player::getPlayerPositionName, PlayerResponse::setPlayerPosition)
                .map(player);
    }

    public Player dtoToEntity(PlayerResponse playerResponse) {
        return modelMapper.typeMap(PlayerResponse.class, Player.class)
                .addMapping(PlayerResponse::getNationality, Player::setNationalityFromCountryName)
                .addMapping(PlayerResponse::getPlayerPosition, Player::setPlayerPositionFromPositionName)
                .map(playerResponse);
    }
}
