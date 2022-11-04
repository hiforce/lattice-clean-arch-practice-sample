package org.hiforce.sample.trade.ability.orderline;

import org.apache.commons.collections4.MapUtils;
import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.sample.trade.ext.orderline.save.BlankTradeOrderLineSaveExt;
import org.hiforce.sample.trade.ext.orderline.save.param.SaveOrderLineExtInput;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Ability(name = "Trade OrderLine save Ability")
public class TradeOrderLineSaveAbility extends BaseLatticeAbility<BlankTradeOrderLineSaveExt> {

    private final OrderLineSpec orderLine;

    public TradeOrderLineSaveAbility(OrderLineSpec orderLine) {
        super(orderLine);
        this.orderLine = orderLine;
    }

    public Map<String, String> getCustomOrderLineAttributes() {
        SaveOrderLineExtInput input = buildSaveOrderLineExtInput();
        return this.reduceExecute(extension -> extension.getCustomOrderLineAttributes(input),
                Reducers.flatMap(MapUtils::isNotEmpty));
    }

    public void processOrderLineBeforeSaving() {
        SaveOrderLineExtInput input = buildSaveOrderLineExtInput();
        this.reduceExecute(extension -> extension.processOrderLineBeforeSaving(input),
                Reducers.none());
    }

    public void finalProcessOrderLineAfterSaving() {
        SaveOrderLineExtInput input = buildSaveOrderLineExtInput();
        this.reduceExecute(extension -> extension.finalProcessOrderLineAfterSaving(input),
                Reducers.none());
    }

    private SaveOrderLineExtInput buildSaveOrderLineExtInput() {
        return new SaveOrderLineExtInput(orderLine);
    }

    @Override
    public BlankTradeOrderLineSaveExt getDefaultRealization() {
        return new BlankTradeOrderLineSaveExt();
    }
}
