package org.hiforce.sample.trade.ext.orderline;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.sample.trade.model.OrderLineDO;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public abstract class OrderLineExtInput implements Serializable {

    private static final long serialVersionUID = 8122138233908128514L;

    @Getter
    @Setter
    private OrderLineDO orderLine;

    public OrderLineExtInput(OrderLineDO orderLine) {
        this.orderLine = orderLine;
    }
}
