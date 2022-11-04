package org.hiforce.sample.scenario.placeorder.session.scope;

import org.hiforce.lattice.model.business.Template;
import org.hiforce.lattice.model.register.BusinessSpec;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.runtime.session.BizSessionScope;
import org.hiforce.sample.scenario.placeorder.model.spec.OrderLineSpec;
import org.hiforce.sample.scenario.placeorder.session.request.PlaceOrderScenarioRequest;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public abstract class PlaceOrderBizSessionScope<Resp> extends BizSessionScope<Resp, OrderLineSpec> {

    public PlaceOrderBizSessionScope(OrderLineSpec orderLineSpec) {
        super(orderLineSpec);
    }

    public PlaceOrderBizSessionScope(List<OrderLineSpec> orderLineSpecs) {
        super(orderLineSpecs);
    }

    @Override
    public PlaceOrderScenarioRequest buildScenarioRequest(OrderLineSpec orderLineSpec) {
        PlaceOrderScenarioRequest request = new PlaceOrderScenarioRequest(orderLineSpec);
        orderLineSpec.setBizCode(Lattice.getInstance().getAllRegisteredBusinesses()
                .stream()
                .map(BusinessSpec::newInstance)
                .filter(p -> p.isEffect(request))
                .map(Template::getCode)
                .findFirst().orElse(null));
        return request;
    }
}
