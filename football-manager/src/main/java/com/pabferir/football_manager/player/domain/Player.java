package com.pabferir.football_manager.player.domain;

import com.pabferir.football_manager.common.domain.annotations.AggregateRoot;
import com.pabferir.football_manager.common.domain.annotations.DomainEntity;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDate;

@AggregateRoot
@DomainEntity
@Getter(AccessLevel.PACKAGE)
class Player {
    private Long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    @Getter(AccessLevel.NONE)
    private Integer age;
    private final Double height;

    Player(Long id, String firstName, String lastName, LocalDate dateOfBirth, Double height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
    }

    Player(String firstName, String lastName, LocalDate dateOfBirth, Double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
    }
}
