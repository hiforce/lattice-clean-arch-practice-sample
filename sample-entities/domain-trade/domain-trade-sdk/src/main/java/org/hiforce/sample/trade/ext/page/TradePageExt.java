package org.hiforce.sample.trade.ext.page;

import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.trade.ext.page.buynow.TradeBuyNowPageExt;
import org.hiforce.sample.trade.ext.page.cart.TradeCartPageExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradePageExt extends IBusinessExt {

    TradeBuyNowPageExt getTradeBuyNowPageExt();

    TradeCartPageExt getTradeCartPageExt();
}
