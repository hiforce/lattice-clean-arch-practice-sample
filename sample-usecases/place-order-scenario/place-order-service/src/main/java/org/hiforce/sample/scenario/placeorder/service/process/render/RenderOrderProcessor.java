package org.hiforce.sample.scenario.placeorder.service.process.render;

import org.hiforce.sample.scenario.placeorder.service.process.BaseProcessor;
import org.hiforce.sample.scenario.placeorder.session.result.ShoppingResult;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public abstract class RenderOrderProcessor extends BaseProcessor<ShoppingResult, List<OrderLineSpec>> {

}
