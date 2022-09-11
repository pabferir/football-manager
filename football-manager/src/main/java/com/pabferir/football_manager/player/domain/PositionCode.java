package com.pabferir.football_manager.player.domain;

import com.pabferir.football_manager.common.domain.annotations.ValueObject;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ValueObject
@Getter
enum PositionCode {

    GK("Goalkeeper"),
    DF("Defense"),
    MF("Midfielder"),
    FW("Forward");

    private final String name;
    private static Map<String, PositionCode> LOOKUP_MAP;

    static {
        LOOKUP_MAP = new HashMap<>();
        for (PositionCode position : PositionCode.values()) {
            LOOKUP_MAP.put(position.getName(), position);
        }
        LOOKUP_MAP = Collections.unmodifiableMap(LOOKUP_MAP);
    }


    PositionCode(String name) {
        this.name = name;
    }

    //TODO make case insensitive
    static PositionCode findByPositionName(String positionName) {
        PositionCode result = LOOKUP_MAP.get(positionName);
        if (result == null) {
            throw new IllegalArgumentException("No PlayerPosition constant with name " + positionName);
        }

        return result;
    }
}
