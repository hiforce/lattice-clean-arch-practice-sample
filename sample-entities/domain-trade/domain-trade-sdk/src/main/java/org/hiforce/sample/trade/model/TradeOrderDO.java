package org.hiforce.sample.trade.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class TradeOrderDO implements Serializable {

    private static final long serialVersionUID = -1801246638356204833L;

    @Getter
    @Setter
    private MainOrderDO bizOrder;

    @Getter
    @Setter
    private PayOrderDO payOrder;

    @Getter
    @Setter
    private LogisticsOrderDO logisticsOrder;
}
