package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.domain.enums.Nationality;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import com.pabferir.football_manager.player.use_cases.UpdatePlayerByIdService;
import com.pabferir.web_api.controllers.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PutPlayerController {

    private final UpdatePlayerByIdService updatePlayerByIdService;

    @Autowired
    public PutPlayerController(UpdatePlayerByIdService updatePlayerByIdService) {
        this.updatePlayerByIdService = updatePlayerByIdService;
    }

    @PutMapping(path = "{id}")
    public Player updatePlayerById(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) LocalDate dateOfBirth,
            @RequestParam(required = false) Double height,
            @RequestParam(required = false) Integer jerseyNumber,
            @RequestParam(required = false) PlayerPosition playerPosition,
            @RequestParam(required = false) Nationality nationality,
            @RequestParam(required = false) Double marketValue) {
        return updatePlayerByIdService.updateById(id, firstName, lastName, dateOfBirth, height, jerseyNumber, playerPosition, nationality, marketValue);
    }
}
