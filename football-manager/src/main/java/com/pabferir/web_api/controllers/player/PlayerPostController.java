package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.application.ports.in.PlayerCreateService;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.CreatePlayerRequest;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Player POST Controller")
@RequestMapping(path = ApiConstants.PLAYER_CONTROLLER)
public class PlayerPostController {
    private final PlayerCreateService playerCreateService;

    @PostMapping
    public PlayerResponse addNewPlayer(@RequestBody CreatePlayerRequest request) {
        PlayerAggregate result = playerCreateService.create(
                request.firstName(),
                request.lastName(),
                request.dateOfBirth(),
                request.height(),
                request.countryOfNationality(),
                request.jerseyNumber(),
                request.playerPositionName(),
                request.currentValueInMillions(),
                request.lastValueUpdate());

        return new PlayerResponse(
                result.getId(),
                result.getFirstName(),
                result.getLastName(),
                result.getDateOfBirth(),
                result.getAge(),
                result.getHeight(),
                result.getCountryName(),
                result.getJerseyNumber(),
                result.getPositionName(),
                result.getCurrentValueInMillions(),
                result.getLastValueUpdate());
    }
}
