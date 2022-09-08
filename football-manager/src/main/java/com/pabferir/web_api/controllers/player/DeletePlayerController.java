package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.use_cases.DeletePlayerService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class DeletePlayerController {

    private final DeletePlayerService deletePlayerService;

    @Autowired
    public DeletePlayerController(DeletePlayerService deletePlayerService) {
        this.deletePlayerService = deletePlayerService;
    }

    @DeleteMapping(path = "{id}")
    public PlayerDTO deletePlayerById(@PathVariable("id") Long id) {
        PlayerDTO result = deletePlayerService.deleteById(id);

        return result;
    }
}
