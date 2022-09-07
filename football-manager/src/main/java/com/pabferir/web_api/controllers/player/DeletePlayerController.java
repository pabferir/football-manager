package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.use_cases.DeletePlayerByIdService;
import com.pabferir.web_api.controllers.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class DeletePlayerController {

    private final DeletePlayerByIdService deletePlayerByIdService;

    @Autowired
    public DeletePlayerController(DeletePlayerByIdService deletePlayerByIdService) {
        this.deletePlayerByIdService = deletePlayerByIdService;
    }

    @DeleteMapping(path = "{id}")
    public Player deletePlayerById(@PathVariable("id") Long id) throws IllegalAccessException {
        return deletePlayerByIdService.deleteById(id);
    }
}
