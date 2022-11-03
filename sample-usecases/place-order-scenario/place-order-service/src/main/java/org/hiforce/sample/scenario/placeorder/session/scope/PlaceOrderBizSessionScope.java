package org.hiforce.sample.scenario.placeorder.session.scope;

import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.sample.scenario.placeorder.model.spec.OrderLineSpec;
import org.hiforce.sample.scenario.placeorder.session.request.PlaceOrderScenarioRequest;
import org.hiforce.sample.scenario.placeorder.session.result.ShoppingResult;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public abstract class PlaceOrderBizSessionScope extends BizSessionScope<ShoppingResult, OrderLineSpec> {

    public PlaceOrderBizSessionScope(OrderLineSpec orderLineSpec) {
        super(orderLineSpec);
    }

    public PlaceOrderBizSessionScope(List<OrderLineSpec> orderLineSpecs) {
        super(orderLineSpecs);
    }

    @Override
    public PlaceOrderScenarioRequest buildScenarioRequest(OrderLineSpec orderLineSpec) {
        return new PlaceOrderScenarioRequest(orderLineSpec);
    }
}
