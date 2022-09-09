package com.pabferir.web_api.controllers.player.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer age;
    private Double height;
    private String nationality;
    private Integer jerseyNumber;
    private String playerPosition;
    private Double marketValueInMillions;
}
