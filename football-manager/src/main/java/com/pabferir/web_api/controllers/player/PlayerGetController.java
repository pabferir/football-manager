package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.application.ports.in.PlayerReadService;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Tag(name = "Player GET Controller")
@RequestMapping(path = ApiConstants.PLAYER_CONTROLLER)
public class PlayerGetController {
    private final PlayerReadService playerReadService;

    @GetMapping
    public List<PlayerResponse> getAllPlayers() {
        List<PlayerAggregate> result = playerReadService.readAll();

        return result.stream()
                .map((p) -> new PlayerResponse(
                        p.getId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getDateOfBirth(),
                        p.getAge(),
                        p.getHeight(),
                        p.getCountryName(),
                        p.getJerseyNumber(),
                        p.getPositionName(),
                        p.getCurrentValueInMillions(),
                        p.getLastValueUpdate()))
                .collect(Collectors.toList());
    }

    //TODO return BadRequest when not found
    @GetMapping(path = "{id}")
    public PlayerResponse getPlayerById(@PathVariable("id") Long id) {
        PlayerAggregate result = playerReadService.readById(id);

        return new PlayerResponse(
                result.getId(),
                result.getFirstName(),
                result.getLastName(),
                result.getDateOfBirth(),
                result.getAge(),
                result.getHeight(),
                result.getCountryName(),
                result.getJerseyNumber(),
                result.getPositionName(),
                result.getCurrentValueInMillions(),
                result.getLastValueUpdate());
    }

    @GetMapping(path = "country={countryName}")
    public List<PlayerResponse> getPlayersByCountry(@PathVariable("countryName") String countryName) {
        List<PlayerAggregate> result = playerReadService.readByCountry(countryName);

        return result.stream()
                .map((p) -> new PlayerResponse(
                        p.getId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getDateOfBirth(),
                        p.getAge(),
                        p.getHeight(),
                        p.getCountryName(),
                        p.getJerseyNumber(),
                        p.getPositionName(),
                        p.getCurrentValueInMillions(),
                        p.getLastValueUpdate()))
                .collect(Collectors.toList());
    }
}
