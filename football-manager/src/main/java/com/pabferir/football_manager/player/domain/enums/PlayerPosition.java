package com.pabferir.football_manager.player.domain.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum PlayerPosition {
    GK("Goalkeeper"),
    DF("Defense"),
    MF("Midfielder"),
    FW("Forward");

    public final String name;
    private static Map<String, PlayerPosition> LOOKUP_MAP;

    static {
        LOOKUP_MAP = new HashMap<>();
        for (PlayerPosition position : PlayerPosition.values()) {
            LOOKUP_MAP.put(position.getName(), position);
        }
        LOOKUP_MAP = Collections.unmodifiableMap(LOOKUP_MAP);
    }

    PlayerPosition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PlayerPosition findByPositionName(String positionName) {
        PlayerPosition result = LOOKUP_MAP.get(positionName);
        if (result == null) {
            throw new IllegalArgumentException("No PlayerPosition constant with name " + positionName);
        }

        return result;
    }
}
