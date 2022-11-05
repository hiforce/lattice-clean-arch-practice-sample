package org.hiforce.sample.presale.scenario.place;

import org.hiforce.lattice.model.ability.BusinessExt;
import org.hiforce.sample.presale.model.PreSaleOrderLine;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class BlankPreSalePlaceOrderExt extends BusinessExt implements PreSalePlaceOrderExt {

    @Override
    public Double getCustomDownPaymentRatio(PreSaleOrderLine orderLine) {
        return null;
    }
}
