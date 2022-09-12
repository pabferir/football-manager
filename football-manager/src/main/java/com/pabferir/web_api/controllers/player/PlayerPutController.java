package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.application.ports.in.PlayerUpdateService;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import com.pabferir.web_api.controllers.player.dtos.UpdatePlayerRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "Player PUT Controller")
@RequestMapping(path = ApiConstants.PLAYER_CONTROLLER)
public class PlayerPutController {
    private final PlayerUpdateService playerUpdateService;

    @PutMapping(path = "{id}")
    public PlayerResponse updatePlayerById(@PathVariable("id") Long id, @RequestBody UpdatePlayerRequest request) {
        PlayerAggregate result = playerUpdateService.update(
                id,
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
