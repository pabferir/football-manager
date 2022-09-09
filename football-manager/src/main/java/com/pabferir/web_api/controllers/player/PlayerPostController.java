package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.ports.services.PlayerCreateService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.AddNewPlayerRequest;
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
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PlayerPostController {

    private final PlayerCreateService playerCreateService;

    @PostMapping
    public PlayerResponse addNewPlayer(@RequestBody AddNewPlayerRequest request) {
        PlayerResponse result = playerCreateService.create(
                request.getFirstName(),
                request.getLastName(),
                request.getDateOfBirth(),
                request.getHeight(),
                request.getCountryOfNationality(),
                request.getJerseyNumber(),
                request.getPlayerPositionName(),
                request.getMarketValueInMillions());

        return result;
    }
}
