package com.pabferir.football_manager.player.domain.entities;

import com.pabferir.football_manager.player.domain.enums.Nationality;
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
    private Integer jerseyNumber;
    @Enumerated(value = EnumType.STRING)
    private PlayerPosition playerPosition;
    @Enumerated(value = EnumType.STRING)
    private Nationality nationality;
    private Double marketValue;

    //region Constructors

    public Player() {
    }

    public Player(Long id,
                  String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  Double height,
                  Integer jerseyNumber,
                  PlayerPosition playerPosition,
                  Nationality nationality,
                  Double marketValue) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.jerseyNumber = jerseyNumber;
        this.playerPosition = playerPosition;
        this.nationality = nationality;
        this.marketValue = marketValue;
    }

    public Player(String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  Double height,
                  Integer jerseyNumber,
                  PlayerPosition playerPosition,
                  Nationality nationality,
                  Double marketValue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.jerseyNumber = jerseyNumber;
        this.playerPosition = playerPosition;
        this.nationality = nationality;
        this.marketValue = marketValue;
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

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer number) {
        this.jerseyNumber = number;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition position) {
        this.playerPosition = position;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
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
                ", marketValue=" + marketValue +
                '}';
    }

    //endregion
}
