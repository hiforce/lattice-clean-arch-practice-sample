package org.hiforce.sample.trade.ability.orderline;

import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.sample.trade.ext.orderline.init.BlankTradeOrderLineInitExt;
import org.hiforce.sample.trade.ext.orderline.init.param.InitOrderLineExtInput;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Ability(name = "Trade OrderLine init Ability")
public class TradeOrderLineInitAbility extends BaseLatticeAbility<BlankTradeOrderLineInitExt> {

    private final OrderLineSpec orderLineSpec;

    public TradeOrderLineInitAbility(OrderLineSpec orderLineSpec) {
        super(orderLineSpec);
        this.orderLineSpec = orderLineSpec;
    }

    public void initOrderLineUnitPrice() {
        InitOrderLineExtInput input = new InitOrderLineExtInput(orderLineSpec);
        BigDecimal unitPrice = this.reduceExecute(extension -> extension.getCustomUnitPrice(input),
                Reducers.firstOf(Objects::nonNull));
        if (null != unitPrice) {
            orderLineSpec.getItem().setUnitPrice(unitPrice);
        }
    }

    @Override
    public BlankTradeOrderLineInitExt getDefaultRealization() {
        return new BlankTradeOrderLineInitExt();
    }
}
