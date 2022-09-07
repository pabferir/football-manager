package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.entities.Player;
import com.pabferir.football_manager.player.use_cases.GetAllPlayersService;
import com.pabferir.football_manager.player.use_cases.GetPlayerByIdService;
import com.pabferir.web_api.controllers.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class GetPlayerController {

    private final GetAllPlayersService getAllPlayersService;
    private final GetPlayerByIdService getPlayerByIdService;

    @Autowired
    public GetPlayerController(GetAllPlayersService getAllPlayersService, GetPlayerByIdService getPlayerByIdService) {
        this.getAllPlayersService = getAllPlayersService;
        this.getPlayerByIdService = getPlayerByIdService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return getAllPlayersService.getAll();
    }

    @GetMapping(path = "{id}")
    public Player getPlayerById(@PathVariable("id") Long id) {
        return getPlayerByIdService.getById(id);
    }
}
