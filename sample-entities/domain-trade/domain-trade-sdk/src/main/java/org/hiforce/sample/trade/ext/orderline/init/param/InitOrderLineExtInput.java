package org.hiforce.sample.trade.ext.orderline.init.param;

import org.hiforce.sample.trade.ext.orderline.OrderLineExtInput;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class InitOrderLineExtInput extends OrderLineExtInput {

    private static final long serialVersionUID = 1241342784843560538L;

    public InitOrderLineExtInput(OrderLineSpec orderLine) {
        super(orderLine);
    }
}
