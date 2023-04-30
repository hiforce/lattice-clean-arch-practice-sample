package org.hiforce.sample.trade.ext.orderline.save;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.annotation.model.ReduceType;
import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.trade.ext.orderline.save.param.SaveOrderLineExtInput;

import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradeOrderLineSaveExt extends IBusinessExt {

    String EXT_DOMAIN_TRADE_ORDER_ATTRIBUTES = "EXT_DOMAIN_TRADE_ORDER_ATTRIBUTES";
    @Extension(reduceType = ReduceType.NONE, code = "EXT_DOMAIN_TRADE_ORDER_ATTRIBUTES")
    Map<String, String> getCustomOrderLineAttributes(SaveOrderLineExtInput input);

    @Extension(reduceType = ReduceType.NONE)
    Void processOrderLineBeforeSaving(SaveOrderLineExtInput input);

    @Extension(reduceType = ReduceType.NONE)
    Void finalProcessOrderLineAfterSaving(SaveOrderLineExtInput input);
}
