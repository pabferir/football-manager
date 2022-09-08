package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.use_cases.ReadPlayerService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class GetPlayerController {

    private final ReadPlayerService readPlayerService;

    @Autowired
    public GetPlayerController(ReadPlayerService readPlayerService) {
        this.readPlayerService = readPlayerService;
    }

    @GetMapping
    public List<PlayerDTO> getPlayers() {
        List<PlayerDTO> result = readPlayerService.getAll();

        return result;
    }

    @GetMapping(path = "{id}")
    public PlayerDTO getPlayerById(@PathVariable("id") Long id) {
        PlayerDTO result = readPlayerService.getById(id);

        return result;
    }

    @GetMapping(path = "country={countryName}")
    public List<PlayerDTO> getPlayerByCountry(@PathVariable("countryName") String countryName) {
        List<PlayerDTO> result = readPlayerService.getByCountry(countryName);

        return result;
    }
}
