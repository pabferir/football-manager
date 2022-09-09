package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.ports.services.PlayerReadService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Player GET Controller")
@RequestMapping(path = ApiConstants.CONTROLLER_PLAYERS)
public class PlayerGetController {

    private final PlayerReadService playerReadService;

    @GetMapping
    public List<PlayerResponse> getAllPlayers() {
        List<PlayerResponse> result = playerReadService.getAll();

        return result;
    }

    @GetMapping(path = "{id}")
    public PlayerResponse getPlayerById(@PathVariable("id") Long id) {
        PlayerResponse result = playerReadService.getById(id);

        return result;
    }

    @GetMapping(path = "country={countryName}")
    public List<PlayerResponse> getPlayersByCountry(@PathVariable("countryName") String countryName) {
        List<PlayerResponse> result = playerReadService.getByCountry(countryName);

        return result;
    }
}
