package org.hiforce.sample.presale;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.presale.scenario.fulfillment.BlankPreSaleFulfillmentExt;
import org.hiforce.sample.presale.scenario.place.BlankPreSalePlaceOrderExt;
import org.hiforce.sample.presale.scenario.refund.BlankPreSaleRefundExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class BlankPreSaleTradeExt extends BusinessExt implements PreSaleTradeExt {
    @Override
    public BlankPreSalePlaceOrderExt getPreSalePlaceOrderExt() {
        return new BlankPreSalePlaceOrderExt();
    }

    @Override
    public BlankPreSaleFulfillmentExt getPreSaleFulfillmentExt() {
        return new BlankPreSaleFulfillmentExt();
    }

    @Override
    public BlankPreSaleRefundExt getPreSaleRefundExt() {
        return new BlankPreSaleRefundExt();
    }
}
