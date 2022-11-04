package org.hiforce.sample.trade.ext.orderline;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public abstract class OrderLineExtInput implements Serializable {

    private static final long serialVersionUID = 8122138233908128514L;

    @Getter
    @Setter
    private OrderLineSpec orderLine;

    public OrderLineExtInput(OrderLineSpec orderLine) {
        this.orderLine = orderLine;
    }
}
