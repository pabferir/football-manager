package com.pabferir.football_manager.player.domain.ports.repository;

import com.pabferir.football_manager.player.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT * FROM player where nationality = :countryCode",
            nativeQuery = true)
    Collection<Player> findByCountry(String countryCode);

}
