package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.use_cases.interfaces.services.CreatePlayerService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.AddNewPlayerRequest;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PostPlayerController {

    private final CreatePlayerService createPlayerService;

    @Autowired
    public PostPlayerController(CreatePlayerService createPlayerService) {
        this.createPlayerService = createPlayerService;
    }

    @PostMapping
    public PlayerDTO addNewPlayer(@RequestBody AddNewPlayerRequest request) {
        PlayerDTO result = createPlayerService.add(
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
