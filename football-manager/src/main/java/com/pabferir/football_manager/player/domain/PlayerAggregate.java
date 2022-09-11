package com.pabferir.football_manager.player.domain;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.common.domain.annotations.Aggregate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.Period;

@Aggregate
@EqualsAndHashCode
public class PlayerAggregate {

    private final Player player;
    private final CountryCode nationality;
    private final Integer jerseyNumber;
    private final PositionCode position;
    private final MarketValue marketValue;


    PlayerAggregate(PlayerAggregateBuilder builder) {
        this.player = builder.getPlayer();
        this.nationality = builder.getNationality();
        this.jerseyNumber = builder.getJerseyNumber();
        this.position = builder.getPosition();
        this.marketValue = builder.getMarketValue();
    }

    public Long getId() {
        return player.getId();
    }

    public String getFirstName() {
        return player.getFirstName();
    }

    public String getLastName() {
        return player.getLastName();
    }

    public LocalDate getDateOfBirth() {
        return player.getDateOfBirth();
    }

    public Integer getAge() {
        return Period.between(player.getDateOfBirth(), LocalDate.now())
                .getYears();
    }

    public Double getHeight() {
        return player.getHeight();
    }

    public String getCountryAlpha2Code() {
        return nationality.getAlpha2();
    }

    public String getCountryName() {
        return nationality.getName();
    }

    public PositionCode getPosition() {
        return position;
    }

    public String getPositionCode() {
        return position.toString();
    }

    public String getPositionName() {
        return position.getName();
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public MarketValue getMarketValue() {
        return marketValue;
    }

    public Double getCurrentValueInMillions() {
        return marketValue.getCurrentValueInMillions();
    }

    public LocalDate getLastValueUpdate() {
        return marketValue.getLastValueUpdate();
    }

    @Override
    public String toString() {
        return "PlayerAggregate{" +
                "id=" + getId().toString() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth().toString() +
                ", age=" + getAge().toString() +
                ", height=" + getHeight().toString() +
                ", nationality=" + getCountryName() +
                ", jerseyNumber=" + jerseyNumber +
                ", position=" + getPositionName() +
                ", currentValueInMillions=" + getCurrentValueInMillions() +
                ", lastValueUpdate=" + getLastValueUpdate() +
                '}';
    }
}
