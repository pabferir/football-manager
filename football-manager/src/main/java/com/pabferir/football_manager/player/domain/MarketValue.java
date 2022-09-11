package com.pabferir.football_manager.player.domain;

import com.pabferir.football_manager.common.domain.annotations.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDate;

@ValueObject
@Getter(AccessLevel.PACKAGE)
class MarketValue {
    private final Double currentValueInMillions;
    private final LocalDate lastValueUpdate;

    MarketValue(Double currentValueInMillions, LocalDate lastValueUpdate) {
        this.currentValueInMillions = currentValueInMillions;
        this.lastValueUpdate = lastValueUpdate;
    }
}
