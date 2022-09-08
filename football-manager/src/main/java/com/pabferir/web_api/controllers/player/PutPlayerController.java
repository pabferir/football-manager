package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.use_cases.UpdatePlayerServiceImpl;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PutPlayerController {

    private final UpdatePlayerServiceImpl updatePlayerServiceImpl;

    @Autowired
    public PutPlayerController(UpdatePlayerServiceImpl updatePlayerServiceImpl) {
        this.updatePlayerServiceImpl = updatePlayerServiceImpl;
    }

    //TODO
    @PutMapping(path = "{id}")
    public PlayerDTO updatePlayerById(
            @PathVariable("id") Long id,
            @RequestAttribute(required = false) String firstName,
            @RequestAttribute(required = false) String lastName,
            @RequestAttribute(required = false) LocalDate dateOfBirth,
            @RequestAttribute(required = false) Double height,
            @RequestAttribute(required = false) String countryOfNationality,
            @RequestAttribute(required = false) Integer jerseyNumber,
            @RequestAttribute(required = false) String playerPositionName,
            @RequestAttribute(required = false) Double marketValue) {
        PlayerDTO result = updatePlayerServiceImpl.update(
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
