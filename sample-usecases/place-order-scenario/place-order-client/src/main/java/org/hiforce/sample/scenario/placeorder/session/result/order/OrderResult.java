package org.hiforce.sample.scenario.placeorder.session.result.order;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.sequence.SequenceGenerator;
import org.hiforce.sample.scenario.placeorder.session.result.promotion.OrderPromotionResult;
import org.hiforce.sample.scenario.placeorder.session.result.render.OrderRenderResult;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class OrderResult implements Serializable {

    private static final long serialVersionUID = 4444405346034482870L;

    @Getter
    private final long orderId = SequenceGenerator.next(OrderResult.class.getName());

    @Getter
    @Setter
    private String buyerId;

    @Getter
    private final List<OrderLineResult> orderLineResults = Lists.newArrayList();

    @Getter
    private final OrderPromotionResult promotionResult = new OrderPromotionResult();

    @Getter
    private final OrderRenderResult renderResult = new OrderRenderResult();
}
