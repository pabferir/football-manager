package com.pabferir.football_manager.player.application.ports.in;

import com.pabferir.football_manager.player.domain.PlayerAggregate;

import java.util.List;

public interface PlayerDeleteService {
    List<PlayerAggregate> deleteAll();
    PlayerAggregate deleteById(Long id);
}
