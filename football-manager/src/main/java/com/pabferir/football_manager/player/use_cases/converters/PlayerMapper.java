package com.pabferir.football_manager.player.use_cases.converters;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PlayerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerDTO entityToDTO(Player player) {
        return modelMapper.typeMap(Player.class, PlayerDTO.class)
                .addMapping(Player::getNationalityCountryName, PlayerDTO::setNationality)
                .addMapping(Player::getPlayerPositionName, PlayerDTO::setPlayerPosition)
                .map(player);
    }

    public Player dtoToEntity(PlayerDTO playerDto) {
        return modelMapper.typeMap(PlayerDTO.class, Player.class)
                .addMapping(PlayerDTO::getNationality, Player::setNationalityFromCountryName)
                .addMapping(PlayerDTO::getPlayerPosition, Player::setPlayerPositionFromPositionName)
                .map(playerDto);
    }
}
