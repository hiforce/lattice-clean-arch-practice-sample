package org.hiforce.sample.presale.ability;

import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.sample.presale.model.PreSaleOrderLine;
import org.hiforce.sample.presale.scenario.place.BlankPreSalePlaceOrderExt;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
@Ability(name = "PreSale OrderLine Ability")
public class PreSaleOrderLineSaveAbility extends BaseLatticeAbility<BlankPreSalePlaceOrderExt> {

    private final PreSaleOrderLine orderLine;

    public PreSaleOrderLineSaveAbility(PreSaleOrderLine orderLine) {
        super(orderLine);
        this.orderLine = orderLine;
    }

    public BigDecimal getCustomDownPaymentRatio() {
        Double ratio = reduceExecute(extension -> extension.getCustomDownPaymentRatio(orderLine),
                Reducers.firstOf(Objects::nonNull));
        return (null == ratio || ratio > 1) ? new BigDecimal(1) : new BigDecimal(ratio);
    }

    @Override
    public BlankPreSalePlaceOrderExt getDefaultRealization() {
        return new BlankPreSalePlaceOrderExt();
    }
}
