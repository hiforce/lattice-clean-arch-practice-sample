package org.hiforce.sample.scenario.placeorder.service;

import org.hiforce.lattice.exception.LatticeRuntimeException;
import org.hiforce.sample.scenario.placeorder.model.dto.BuyItemDTO;
import org.hiforce.sample.scenario.placeorder.model.spec.BuyItemSpec;
import org.hiforce.sample.scenario.placeorder.model.spec.OrderLineSpec;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderRespDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderRespDTO;
import org.hiforce.sample.scenario.placeorder.session.result.ShoppingResult;
import org.hiforce.sample.scenario.placeorder.session.scope.PlaceOrderBizSessionScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
@Service
public class DefaultPlaceOrderService implements PlaceOrderService {

    @Override
    public RenderOrderRespDTO renderOrder(RenderOrderReqDTO reqDTO) {
        List<OrderLineSpec> orderLineSpec = reqDTO.getItems().stream()
                .map(p -> buildOrderLineSpec(reqDTO, p))
                .collect(Collectors.toList());
        ShoppingResult result = new PlaceOrderBizSessionScope<ShoppingResult>(orderLineSpec) {
            @Override
            protected ShoppingResult execute() throws LatticeRuntimeException {
                ShoppingResult shoppingResult = new ShoppingResult();
                return shoppingResult;
            }
        }.invoke();

        return null;
    }

    @Override
    public CreateOrderRespDTO createOrder(CreateOrderReqDTO reqDTO) {
        return null;
    }

    private OrderLineSpec buildOrderLineSpec(RenderOrderReqDTO reqDTO, BuyItemDTO buyItemDTO) {
        OrderLineSpec orderLineSpec = new OrderLineSpec();
        orderLineSpec.getRequestParams().putAll(reqDTO.getRequestParams());
        orderLineSpec.setBuyerId(reqDTO.getBuyerId());
        BuyItemSpec item = new BuyItemSpec();
        orderLineSpec.setItem(item);
        item.setItemId(buyItemDTO.getItemId());
        item.setBuyQuantity(buyItemDTO.getBuyQuantity());
        item.getFeatures().putAll(buyItemDTO.getExtraParams());
        return orderLineSpec;
    }
}
