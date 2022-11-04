package org.hiforce.sample.trade.ext.orderline;

import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.trade.ext.orderline.check.TradeOrderLineCheckExt;
import org.hiforce.sample.trade.ext.orderline.init.TradeOrderLineInitExt;
import org.hiforce.sample.trade.ext.orderline.save.TradeOrderLineSaveExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradeOrderLineExt extends IBusinessExt {

    /**
     * @return The extension of Order Line entity in init behavior.
     */
    TradeOrderLineInitExt getTradeOrderLineInitExt();

    /**
     * @return The extension of Order Line entity in check behavior.
     */
    TradeOrderLineCheckExt getTradeOrderLineCheckExt();

    /**
     * @return The extension of Order Line entity in saving behavior.
     */
    TradeOrderLineSaveExt getTradeOrderLineSaveExt();
}
