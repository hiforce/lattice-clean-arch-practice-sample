package org.hiforce.sample.trade.ext;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.trade.ext.order.BlankTradeOrderExt;
import org.hiforce.sample.trade.ext.orderline.BlankTradeOrderLineExt;
import org.hiforce.sample.trade.ext.page.BlankTradePageExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class BlankTradeEntityExt extends BusinessExt implements TradeEntityExt {
    @Override
    public BlankTradeOrderExt getTradeOrderExt() {
        return new BlankTradeOrderExt();
    }

    @Override
    public BlankTradeOrderLineExt getTradeOrderLineExt() {
        return new BlankTradeOrderLineExt();
    }

    @Override
    public BlankTradePageExt getTradePageExt() {
        return new BlankTradePageExt();
    }
}
