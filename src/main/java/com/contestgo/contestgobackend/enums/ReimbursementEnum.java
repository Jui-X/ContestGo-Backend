package com.contestgo.contestgobackend.enums;

import lombok.Getter;

@Getter
public enum ReimbursementEnum {
    TRAFFIC(1),
    OFFICE_SUPPLIES(2),
    COMPUTER_ACCESSORIES(3),
    BOOK(4),
    PRINT(5),
    CONSUMABLE(6)
    ;

    private int type;

    ReimbursementEnum(int type) {
        this.type = type;
    }
}
