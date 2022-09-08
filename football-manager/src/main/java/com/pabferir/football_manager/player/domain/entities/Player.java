package com.pabferir.football_manager.player.domain.entities;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.domain.enums.PlayerPosition;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
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

    //region Constructors

    public Player() {
    }

    public Player(Long id,
                  String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  Double height,
                  CountryCode nationality,
                  Integer jerseyNumber,
                  PlayerPosition playerPosition,
                  Double marketValueInMillions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.nationality = nationality;
        this.jerseyNumber = jerseyNumber;
        this.playerPosition = playerPosition;
        this.marketValueInMillions = marketValueInMillions;
    }

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

    //endregion

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public CountryCode getNationality() {
        return nationality;
    }

    public void setNationality(CountryCode nationality) {
        this.nationality = nationality;
    }

    public void setNationalityFromCountryName(String countryName) {
        this.nationality = CountryCode.findByName(countryName).get(0);
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer number) {
        this.jerseyNumber = number;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setPlayerPositionFromPositionName(String positionName) {
        this.playerPosition = PlayerPosition.findByPositionName(positionName);
    }

    public Double getMarketValueInMillions() {
        return marketValueInMillions;
    }

    public void setMarketValueInMillions(Double marketValue) {
        this.marketValueInMillions = marketValue;
    }

    public String getNationalityCountryName() {
        return nationality.getName();
    }

    public String getPlayerPositionName() {
        return playerPosition.getName();
    }

    //endregion

    //region Overrides

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", jerseyNumber=" + jerseyNumber +
                ", playerPosition=" + playerPosition +
                ", nationality=" + nationality +
                ", marketValue=" + marketValueInMillions +
                '}';
    }

    //endregion
}
