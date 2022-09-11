package com.pabferir.football_manager.player.infrastructure.repository;

import com.pabferir.football_manager.player.application.ports.out.PlayerRepository;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.football_manager.player.infrastructure.helpers.PlayerMapper;
import com.pabferir.football_manager.player.infrastructure.table_mapping.PlayerTableEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Slf4j
public class PlayerPostgreSQLRepository implements PlayerRepository {
    private final PlayerMapper playerMapper;
    private final PlayerJpaRepository playerJpaRepository;

    @Override
    public PlayerAggregate insert(PlayerAggregate playerAggregate) {
        PlayerTableEntity result = playerJpaRepository.save(
                playerMapper.aggregateToTableEntity(playerAggregate));

        return playerMapper.tableEntityToAggregate(result);
    }

    @Override
    public Collection<PlayerAggregate> selectAll() {
        List<PlayerTableEntity> result = playerJpaRepository.findAll();

        return result.stream()
                .map(playerMapper::tableEntityToAggregate)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerAggregate> selectById(Long id) {
        Optional<PlayerTableEntity> result = playerJpaRepository.findById(id);

        return result.map(playerMapper::tableEntityToAggregate);
    }

    @Override
    public Collection<PlayerAggregate> selectByCountry(String countryName) {
        List<PlayerTableEntity> result = playerJpaRepository.findByCountry(countryName);

        return result.stream()
                .map(playerMapper::tableEntityToAggregate)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        playerJpaRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        playerJpaRepository.deleteById(id);
    }

    @Override
    public PlayerAggregate update(PlayerAggregate playerAggregate) {
        PlayerTableEntity result = playerJpaRepository.save(
                playerMapper.aggregateToTableEntity(playerAggregate));

        return playerMapper.tableEntityToAggregate(result);
    }
}
