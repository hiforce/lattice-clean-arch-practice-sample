package org.hiforce.sample.trade.model.type;

import lombok.Getter;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public enum OrderType {

    MAIN_ORDER(true),
    SUB_ORDER(false),
    MAIN_AND_SUB_ORDER(true);


    @Getter
    private final boolean mainOrder;

    OrderType(boolean mainOrder) {
        this.mainOrder = mainOrder;
    }
}
