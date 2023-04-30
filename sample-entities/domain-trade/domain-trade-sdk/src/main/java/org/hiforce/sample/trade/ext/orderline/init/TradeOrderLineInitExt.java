package org.hiforce.sample.trade.ext.orderline.init;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.annotation.model.ReduceType;
import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.trade.ext.orderline.init.param.InitOrderLineExtInput;

import java.math.BigDecimal;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradeOrderLineInitExt extends IBusinessExt {

    String EXT_DOMAIN_ORDER_CUSTOM_UNIT_PRICE = "EXT_DOMAIN_ORDER_CUSTOM_UNIT_PRICE";
    @Extension(reduceType = ReduceType.FIRST, code = "EXT_DOMAIN_ORDER_CUSTOM_UNIT_PRICE")
    BigDecimal getCustomUnitPrice(InitOrderLineExtInput input);
}
