package org.hiforce.sample.trade.ext.page;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.trade.ext.page.buynow.BlankTradeBuyNowPageExt;
import org.hiforce.sample.trade.ext.page.cart.BlankTradeCartPageExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class BlankTradePageExt extends BusinessExt implements TradePageExt {

    @Override
    public BlankTradeBuyNowPageExt getTradeBuyNowPageExt() {
        return new BlankTradeBuyNowPageExt();
    }

    @Override
    public BlankTradeCartPageExt getTradeCartPageExt() {
        return new BlankTradeCartPageExt();
    }
}
