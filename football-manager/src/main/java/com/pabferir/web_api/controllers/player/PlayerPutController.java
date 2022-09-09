package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.ports.services.PlayerUpdateService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Tag(name = "Player PUT Controller")
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PlayerPutController {

    private final PlayerUpdateService updatePlayerService;

    //TODO
    @PutMapping(path = "{id}")
    public PlayerResponse updatePlayerById(
            @PathVariable("id") Long id,
            @RequestAttribute(required = false) String firstName,
            @RequestAttribute(required = false) String lastName,
            @RequestAttribute(required = false) LocalDate dateOfBirth,
            @RequestAttribute(required = false) Double height,
            @RequestAttribute(required = false) String countryOfNationality,
            @RequestAttribute(required = false) Integer jerseyNumber,
            @RequestAttribute(required = false) String playerPositionName,
            @RequestAttribute(required = false) Double marketValue) {
        PlayerResponse result = updatePlayerService.update(
                id,
                firstName,
                lastName,
                dateOfBirth,
                height,
                countryOfNationality,
                jerseyNumber,
                playerPositionName,
                marketValue);

        return result;
    }
}
