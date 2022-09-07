package com.pabferir.football_manager.player.domain.enums;

public enum PlayerPosition {
    GK("Goalkeeper"),
    DF("Defense"),
    MF("Midfielder"),
    FW("Forward");

    public final String name;

    PlayerPosition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
