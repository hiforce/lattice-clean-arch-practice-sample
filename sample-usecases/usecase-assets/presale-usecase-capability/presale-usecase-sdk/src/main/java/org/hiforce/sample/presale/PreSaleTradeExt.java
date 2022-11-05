package org.hiforce.sample.presale;

import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.presale.scenario.fulfillment.PreSaleFulfillmentExt;
import org.hiforce.sample.presale.scenario.place.PreSalePlaceOrderExt;
import org.hiforce.sample.presale.scenario.refund.PreSaleRefundExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface PreSaleTradeExt extends IBusinessExt {

    /**
     * @return The extensions of PreSale trade in buyer place order.
     */
    PreSalePlaceOrderExt getPreSalePlaceOrderExt();

    /**
     * @return The extensions of PreSale trade in fulfillment.
     */
    PreSaleFulfillmentExt getPreSaleFulfillmentExt();

    /**
     * @return The extensions of PreSale trade in refund.
     */
    PreSaleRefundExt getPreSaleRefundExt();
}
