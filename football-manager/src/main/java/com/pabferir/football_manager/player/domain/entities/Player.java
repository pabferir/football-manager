package com.pabferir.football_manager.player.domain.entities;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {

    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Transient
    private Integer age;
    private Double height;
    @Enumerated(value = EnumType.STRING)
    private CountryCode nationality;
    private Integer jerseyNumber;
    @Enumerated(value = EnumType.STRING)
    private PlayerPosition playerPosition;
    private Double marketValueInMillions;

    public Player(String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  Double height,
                  CountryCode nationality,
                  Integer jerseyNumber,
                  PlayerPosition playerPosition,
                  Double marketValueInMillions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.nationality = nationality;
        this.jerseyNumber = jerseyNumber;
        this.playerPosition = playerPosition;
        this.marketValueInMillions = marketValueInMillions;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNationalityFromCountryName(String countryName) {
        this.nationality = CountryCode.findByName(countryName).get(0);
    }

    public void setPlayerPositionFromPositionName(String positionName) {
        this.playerPosition = PlayerPosition.findByPositionName(positionName);
    }

    public String getNationalityCountryName() {
        return nationality.getName();
    }

    public String getPlayerPositionName() {
        return playerPosition.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Player player = (Player) o;
        return id != null && Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
