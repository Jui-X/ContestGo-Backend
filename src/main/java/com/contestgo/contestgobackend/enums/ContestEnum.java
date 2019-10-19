package com.contestgo.contestgobackend.enums;

import lombok.Getter;

@Getter
public enum ContestEnum {

    SCIENTIFIC_CONTEST(1),
    SPORT_CONTEST(2)
    ;

    private int type;

    ContestEnum(int type) {
        this.type = type;
    }
}
