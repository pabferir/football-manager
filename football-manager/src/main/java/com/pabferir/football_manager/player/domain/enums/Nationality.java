package com.pabferir.football_manager.player.domain.enums;

public enum Nationality {
    ES("Spain"),
    EN("England"),
    IT("Italy"),
    GE("Germany"),
    FR("France"),
    AR("Argentina"),
    PT("Portugal");

    private final String country;

    Nationality(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
