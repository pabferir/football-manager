package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.use_cases.AddNewPlayerService;
import com.pabferir.web_api.controllers.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PostPlayerController {

    private final AddNewPlayerService addNewPlayerService;

    @Autowired
    public PostPlayerController(AddNewPlayerService addNewPlayerService) {
        this.addNewPlayerService = addNewPlayerService;
    }

    @PostMapping
    public Player addNewPlayer(@RequestBody Player player) {
        return addNewPlayerService.addNew(player);
    }
}
