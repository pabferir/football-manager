package com.pabferir.football_manager.player.infrastructure.repository;

import com.pabferir.football_manager.player.infrastructure.table_mapping.PlayerTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerTableEntity, Long> {

    @Query(value = "SELECT * FROM player where nationality = :countryCode",
            nativeQuery = true)
    List<PlayerTableEntity> findByCountry(String countryCode);
}
