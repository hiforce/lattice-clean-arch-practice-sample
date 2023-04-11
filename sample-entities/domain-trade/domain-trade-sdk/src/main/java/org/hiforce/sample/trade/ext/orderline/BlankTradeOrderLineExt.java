package org.hiforce.sample.trade.ext.orderline;

import org.hiforce.lattice.annotation.Schema;
import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.trade.ext.orderline.check.BlankTradeOrderLineCheckExt;
import org.hiforce.sample.trade.ext.orderline.init.BlankTradeOrderLineInitExt;
import org.hiforce.sample.trade.ext.orderline.init.TradeOrderLineInitExt;
import org.hiforce.sample.trade.ext.orderline.save.BlankTradeOrderLineSaveExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Schema(root = true)
public class BlankTradeOrderLineExt extends BusinessExt implements TradeOrderLineExt {
    @Override
    public BlankTradeOrderLineInitExt getTradeOrderLineInitExt() {
        return new BlankTradeOrderLineInitExt();
    }

    @Override
    public BlankTradeOrderLineCheckExt getTradeOrderLineCheckExt() {
        return new BlankTradeOrderLineCheckExt();
    }

    @Override
    public BlankTradeOrderLineSaveExt getTradeOrderLineSaveExt() {
        return new BlankTradeOrderLineSaveExt();
    }
}
