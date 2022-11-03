package org.hiforce.sample.scenario.placeorder.service;

import org.hiforce.sample.scenario.placeorder.model.dto.BuyItemDTO;
import org.hiforce.sample.scenario.placeorder.model.spec.OrderLineSpec;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderRespDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderRespDTO;
import org.springframework.stereotype.Service;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
@Service
public class DefaultPlaceOrderService implements PlaceOrderService {

    @Override
    public RenderOrderRespDTO renderOrder(RenderOrderReqDTO reqDTO) {
        return null;
    }

    @Override
    public CreateOrderRespDTO createOrder(CreateOrderReqDTO reqDTO) {
        return null;
    }

    private OrderLineSpec buildOrderLineSpec(BuyItemDTO buyItemDTO){
        OrderLineSpec orderLineSpec = new OrderLineSpec();
        return orderLineSpec;
    }
}
