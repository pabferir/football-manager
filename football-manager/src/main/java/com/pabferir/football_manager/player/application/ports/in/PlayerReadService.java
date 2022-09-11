package com.pabferir.football_manager.player.application.ports.in;

import com.pabferir.football_manager.player.domain.PlayerAggregate;

import java.util.List;

public interface PlayerReadService {
    List<PlayerAggregate> readAll();

    PlayerAggregate readById(Long id);

    List<PlayerAggregate> readByCountry(String countryName);
}
