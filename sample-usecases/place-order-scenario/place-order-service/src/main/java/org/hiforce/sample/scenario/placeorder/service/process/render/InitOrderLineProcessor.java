package org.hiforce.sample.scenario.placeorder.service.process.render;

import org.hiforce.lattice.runtime.utils.SpringApplicationContextHolder;
import org.hiforce.sample.scenario.placeorder.session.result.ShoppingResult;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;
import org.hiforce.sample.trade.service.TradeService;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class InitOrderLineProcessor extends RenderOrderProcessor {

    private final TradeService tradeService = SpringApplicationContextHolder.getSpringBean(TradeService.class);

    @Override
    public ShoppingResult process(ShoppingResult shoppingResult, List<OrderLineSpec> orderLineSpecs) {
        tradeService.initBuildOrderLines(orderLineSpecs);
        return shoppingResult;
    }
}
