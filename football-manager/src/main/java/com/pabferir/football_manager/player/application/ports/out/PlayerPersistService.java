package com.pabferir.football_manager.player.application.ports.out;

import com.pabferir.football_manager.player.domain.PlayerAggregate;

import java.util.Collection;
import java.util.Optional;

public interface PlayerPersistService {
    PlayerAggregate insert(PlayerAggregate playerAggregate);
    Collection<PlayerAggregate> selectAll();
    Optional<PlayerAggregate> selectById(Long id);
    Collection<PlayerAggregate> selectByCountry(String countryName);
    void deleteAll();
    void deleteById(Long id);
    PlayerAggregate update(PlayerAggregate playerAggregate);
}
