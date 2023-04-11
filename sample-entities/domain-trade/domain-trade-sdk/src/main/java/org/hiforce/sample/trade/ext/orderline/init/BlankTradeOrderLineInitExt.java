package org.hiforce.sample.trade.ext.orderline.init;

import org.hiforce.lattice.annotation.Schema;
import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.trade.ext.orderline.init.param.InitOrderLineExtInput;

import java.math.BigDecimal;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Schema(root = true)
public class BlankTradeOrderLineInitExt extends BusinessExt implements TradeOrderLineInitExt {
    @Override
    public BigDecimal getCustomUnitPrice(InitOrderLineExtInput input) {
        return null;
    }
}
