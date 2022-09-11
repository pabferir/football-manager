package com.pabferir.football_manager.player.domain;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.common.domain.annotations.AggregateBuilder;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDate;

@AggregateBuilder
@Getter(AccessLevel.PACKAGE)
public class PlayerAggregateBuilder {

    private Player player;
    private CountryCode nationality;
    private Integer jerseyNumber;
    private PositionCode position;
    private MarketValue marketValue;


    public PlayerAggregateBuilder forPlayer(String firstName,
                                            String lastName,
                                            LocalDate dateOfBirth,
                                            Double height) {
        if (this.player != null) {
            throw new IllegalArgumentException("Player's root has already been set");
        }
        this.player = new Player(firstName, lastName, dateOfBirth, height);

        return this;
    }

    public PlayerAggregateBuilder forPlayer(Long id,
                                            String firstName,
                                            String lastName,
                                            LocalDate dateOfBirth,
                                            Double height) {
        if (this.player != null) {
            throw new IllegalArgumentException("Player's root has already been set");
        }
        this.player = new Player(id, firstName, lastName, dateOfBirth, height);

        return this;
    }

    public PlayerAggregateBuilder withCountryName(String countryName) {
        if (this.nationality != null) {
            throw new IllegalArgumentException("Player's nationality has already been set");
        }
        this.nationality = CountryCode.findByName("(?i).*" + countryName + ".*")
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Could not find country with name " + countryName));

        return this;
    }

    public PlayerAggregateBuilder withCountryCode(String countryCode) {
        if (this.nationality != null) {
            throw new IllegalArgumentException("Player's nationality has already been set");
        }
        this.nationality = CountryCode.getByCode(countryCode, false);

        return this;
    }

    public PlayerAggregateBuilder withJerseyNumber(Integer jerseyNumber) {
        if (this.jerseyNumber != null) {
            throw new IllegalArgumentException("Player's jersey number has already been set");
        }
        this.jerseyNumber = jerseyNumber;

        return this;
    }

    public PlayerAggregateBuilder withPositionName(String positionName) {
        if (this.position != null) {
            throw new IllegalArgumentException("Player's position has already been set");
        }
        this.position = PositionCode.findByPositionName(positionName);

        return this;
    }

    public PlayerAggregateBuilder withPositionCode(String positionCode) {
        if (this.position != null) {
            throw new IllegalArgumentException("Player's position has already been set");
        }
        this.position = PositionCode.valueOf(positionCode.toUpperCase());

        return this;
    }

    public PlayerAggregateBuilder withMarketValue(Double currentValueInMillions,
                                                  LocalDate lastValueUpdate) {
        if (this.marketValue != null) {
            throw new IllegalArgumentException("Player's market value has already been set");
        }
        this.marketValue = new MarketValue(currentValueInMillions, lastValueUpdate);

        return this;
    }

    public PlayerAggregate build() {
        return new PlayerAggregate(this);
    }
}
