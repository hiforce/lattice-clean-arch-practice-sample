package org.hiforce.sample.scenario.placeorder.session.result.order;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.sample.scenario.placeorder.session.result.promotion.OrderLinePromotionResult;
import org.hiforce.sample.scenario.placeorder.session.result.render.OrderLineRenderResult;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class OrderLineResult implements Serializable {

    private static final long serialVersionUID = 6149799047943732874L;

    @Getter
    @Setter
    private long orderId;

    @Getter
    @Setter
    private OrderLineSpec orderLineSpec;

    @Getter
    private final OrderLineRenderResult renderResult = new OrderLineRenderResult();

    @Getter
    private final OrderLinePromotionResult promotionResult = new OrderLinePromotionResult();

}
