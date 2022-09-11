package com.pabferir.football_manager.player.infrastructure.helpers;

import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.football_manager.player.domain.PlayerAggregateBuilder;
import com.pabferir.football_manager.player.infrastructure.table_mapping.PlayerTableEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerMapper {
    public PlayerAggregate tableEntityToAggregate(PlayerTableEntity tableEntity) {
        return new PlayerAggregateBuilder()
                .forPlayer(tableEntity.getId(),
                        tableEntity.getFirstName(),
                        tableEntity.getLastName(),
                        tableEntity.getDateOfBirth(),
                        tableEntity.getHeight())
                .withCountryCode(tableEntity.getCountryCode())
                .withJerseyNumber(tableEntity.getJerseyNumber())
                .withPositionCode(tableEntity.getPositionCode())
                .withMarketValue(tableEntity.getCurrentValueInMillions(), tableEntity.getLastValueUpdate())
                .build();
    }

    public PlayerTableEntity aggregateToTableEntity(PlayerAggregate aggregate) {
        return new PlayerTableEntity(
                aggregate.getId(),
                aggregate.getFirstName(),
                aggregate.getLastName(),
                aggregate.getDateOfBirth(),
                aggregate.getAge(),
                aggregate.getHeight(),
                aggregate.getCountryAlpha2Code(),
                aggregate.getJerseyNumber(),
                aggregate.getPositionCode(),
                aggregate.getCurrentValueInMillions(),
                aggregate.getLastValueUpdate());
    }
}
