package org.hiforce.sample.trade.ext.orderline.save.param;

import org.hiforce.sample.trade.ext.orderline.OrderLineExtInput;
import org.hiforce.sample.trade.model.OrderLineDO;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class SaveOrderLineExtInput extends OrderLineExtInput {

    private static final long serialVersionUID = 1241342784843560538L;

    public SaveOrderLineExtInput(OrderLineDO orderLine) {
        super(orderLine);
    }
}
