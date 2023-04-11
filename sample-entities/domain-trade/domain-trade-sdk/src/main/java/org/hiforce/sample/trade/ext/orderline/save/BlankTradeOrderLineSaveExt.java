package org.hiforce.sample.trade.ext.orderline.save;

import org.hiforce.lattice.annotation.Schema;
import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.trade.ext.orderline.save.param.SaveOrderLineExtInput;

import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Schema(root = true)
public class BlankTradeOrderLineSaveExt extends BusinessExt implements TradeOrderLineSaveExt {

    @Override
    public Map<String, String> getCustomOrderLineAttributes(SaveOrderLineExtInput input) {
        return null;
    }

    @Override
    public Void processOrderLineBeforeSaving(SaveOrderLineExtInput input) {
        return null;
    }

    @Override
    public Void finalProcessOrderLineAfterSaving(SaveOrderLineExtInput input) {
        return null;
    }
}
