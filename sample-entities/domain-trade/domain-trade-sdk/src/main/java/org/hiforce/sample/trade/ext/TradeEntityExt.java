package org.hiforce.sample.trade.ext;

import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.trade.ext.order.TradeOrderExt;
import org.hiforce.sample.trade.ext.orderline.TradeOrderLineExt;
import org.hiforce.sample.trade.ext.page.TradePageExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradeEntityExt extends IBusinessExt {

    TradeOrderExt getTradeOrderExt();

    TradeOrderLineExt getTradeOrderLineExt();

    TradePageExt getTradePageExt();
}
