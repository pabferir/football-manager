package com.pabferir.web_api.controllers.player;

import com.pabferir.football_manager.player.domain.ports.services.PlayerDeleteService;
import com.pabferir.web_api.controllers.ApiConstants;
import com.pabferir.web_api.controllers.player.dtos.PlayerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Player DELETE Controller")
@RequestMapping(path = ApiConstants.PLAYER_CONTROLLER)
public class PlayerDeleteController {

    private final PlayerDeleteService playerDeleteService;

    @DeleteMapping(path = "{id}")
    public PlayerResponse deletePlayerById(@PathVariable("id") Long id) {
        PlayerResponse result = playerDeleteService.deleteById(id);

        return result;
    }
}
