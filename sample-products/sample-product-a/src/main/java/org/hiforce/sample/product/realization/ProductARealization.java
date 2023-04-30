package org.hiforce.sample.product.realization;

import org.hiforce.lattice.annotation.Realization;
import org.hiforce.sample.presale.BlankPreSaleTradeExt;
import org.hiforce.sample.presale.model.PreSaleOrderLine;
import org.hiforce.sample.presale.scenario.place.BlankPreSalePlaceOrderExt;
import org.hiforce.sample.product.SampleProductA;

/**
 * @author Rocky Yu
 * @since 2023/4/30
 */
@Realization(codes = SampleProductA.CODE)
public class ProductARealization extends BlankPreSaleTradeExt {

    @Override
    public BlankPreSalePlaceOrderExt getPreSalePlaceOrderExt() {
        return new BlankPreSalePlaceOrderExt() {
            @Override
            public Double getCustomDownPaymentRatio(PreSaleOrderLine orderLine) {
                return 0.2;
            }
        };
    }
}
