package org.hiforce.sample.scenario.placeorder.session.request;

import lombok.Getter;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class PlaceOrderScenarioRequest implements ScenarioRequest {

    private static final long serialVersionUID = -602336109697921355L;

    @Getter
    private final OrderLineSpec orderLine;

    public PlaceOrderScenarioRequest(OrderLineSpec orderLine) {
        this.orderLine = orderLine;
    }

    @Override
    public OrderLineSpec getBizObject() {
        return orderLine;
    }
}
