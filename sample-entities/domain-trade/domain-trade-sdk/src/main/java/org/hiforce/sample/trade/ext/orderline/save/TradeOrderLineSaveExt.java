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

    @Extension(reduceType = ReduceType.NONE)
    Map<String, String> getCustomOrderLineAttributes(SaveOrderLineExtInput input);

    @Extension(reduceType = ReduceType.NONE)
    Void processOrderLineBeforeSaving(SaveOrderLineExtInput input);

    @Extension(reduceType = ReduceType.NONE)
    Void finalProcessOrderLineAfterSaving(SaveOrderLineExtInput input);
}
