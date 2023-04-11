package org.hiforce.sample.business.realization.presale;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.lattice.annotation.Schema;
import org.hiforce.sample.business.SampleBusinessA;
import org.hiforce.sample.presale.BlankPreSaleTradeExt;
import org.hiforce.sample.presale.model.PreSaleOrderLine;
import org.hiforce.sample.presale.scenario.place.BlankPreSalePlaceOrderExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Realization(codes = SampleBusinessA.CODE)
public class BusinessAPreSaleExt extends BlankPreSaleTradeExt {
    @Override
    public BlankPreSalePlaceOrderExt getPreSalePlaceOrderExt() {
        return new BlankPreSalePlaceOrderExt() {
            @Override
            public Double getCustomDownPaymentRatio(PreSaleOrderLine orderLine) {
                return 0.4;
            }
        };
    }
}
