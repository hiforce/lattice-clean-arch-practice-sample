package org.hiforce.sample.presale.scenario.place;

import org.hiforce.lattice.annotation.Extension;
import org.hiforce.lattice.model.ability.IBusinessExt;
import org.hiforce.sample.presale.model.PreSaleOrderLine;

import static org.hiforce.lattice.annotation.model.ReduceType.FIRST;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface PreSalePlaceOrderExt extends IBusinessExt {

    String EXT_PRE_SALE_CUSTOM_PAYMENT_RATIO = "EXT_PRE_SALE_CUSTOM_PAYMENT_RATIO";
    @Extension(code = "EXT_PRE_SALE_CUSTOM_PAYMENT_RATIO", name = "Custom PreSale Down Payment Ratio", reduceType = FIRST)
    Double getCustomDownPaymentRatio(PreSaleOrderLine orderLine);
}
