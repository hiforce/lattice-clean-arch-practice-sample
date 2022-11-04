package org.hiforce.sample.scenario.placeorder.service;

import com.google.common.collect.Lists;
import org.hiforce.lattice.exception.LatticeRuntimeException;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderRespDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderRespDTO;
import org.hiforce.sample.scenario.placeorder.service.process.render.InitOrderLineProcessor;
import org.hiforce.sample.scenario.placeorder.service.process.render.RenderOrderProcessor;
import org.hiforce.sample.scenario.placeorder.session.result.ShoppingResult;
import org.hiforce.sample.scenario.placeorder.session.result.order.OrderLineResult;
import org.hiforce.sample.scenario.placeorder.session.result.order.OrderResult;
import org.hiforce.sample.scenario.placeorder.session.scope.PlaceOrderBizSessionScope;
import org.hiforce.sample.trade.model.dto.BuyItemDTO;
import org.hiforce.sample.trade.model.dto.OrderDTO;
import org.hiforce.sample.trade.model.dto.OrderLineDTO;
import org.hiforce.sample.trade.model.spec.BuyItemSpec;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
@Service
public class DefaultPlaceOrderService implements PlaceOrderService {

    @Override
    public RenderOrderRespDTO renderOrder(RenderOrderReqDTO reqDTO) {
        List<OrderLineSpec> orderLineSpecs = reqDTO.getItems().stream()
                .map(p -> buildOrderLineSpec(reqDTO.getBuyerId(), p, reqDTO.getRequestParams()))
                .collect(Collectors.toList());

        ShoppingResult result = new PlaceOrderBizSessionScope<ShoppingResult>(orderLineSpecs) {
            @Override
            protected ShoppingResult execute() throws LatticeRuntimeException {
                List<RenderOrderProcessor> processors = Lists.newArrayList(
                        new InitOrderLineProcessor()
                );
                ShoppingResult shoppingResult = initShoppingResult(reqDTO, orderLineSpecs);
                processors.forEach(p -> p.process(shoppingResult, orderLineSpecs));
                return shoppingResult;
            }
        }.invoke();

        //build the response via ShoppingResult.
        return buildRenderOrderRespDTO(result);
    }

    @Override
    public CreateOrderRespDTO createOrder(CreateOrderReqDTO reqDTO) {
        return null;
    }

    private RenderOrderRespDTO buildRenderOrderRespDTO(ShoppingResult result) {
        RenderOrderRespDTO respDTO = new RenderOrderRespDTO();
        respDTO.setSuccess(true);
        respDTO.getOrders().addAll(result.getOrderResults().stream().map(this::buildOrderDTO)
                .collect(Collectors.toList()));
        return respDTO;
    }

    private OrderDTO buildOrderDTO(OrderResult orderResult) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerId(orderResult.getBuyerId());
        orderDTO.setOrderId(orderResult.getOrderId());
        orderDTO.getOrderLines().addAll(orderResult.getOrderLineResults().stream()
                .map(this::buildOrderLineDTO).collect(Collectors.toList()));
        return orderDTO;
    }

    private OrderLineDTO buildOrderLineDTO(OrderLineResult orderLineResult) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        OrderLineSpec orderLineSpec = orderLineResult.getOrderLineSpec();
        orderLineDTO.setOrderLineId(orderLineSpec.getOrderLineId());
        orderLineDTO.setItemId(orderLineSpec.getItem().getItemId());
        orderLineDTO.setBuyQuantity(orderLineSpec.getItem().getBuyQuantity());
        orderLineDTO.setUnitPrice(orderLineSpec.getItem().getUnitPrice().longValue());
        orderLineDTO.getAttributes().putAll(orderLineSpec.getAttributes());
        orderLineDTO.getItemFeatures().putAll(orderLineSpec.getItem().getFeatures());
        return orderLineDTO;
    }

    private ShoppingResult initShoppingResult(RenderOrderReqDTO reqDTO, List<OrderLineSpec> orderLineSpecs) {
        ShoppingResult shoppingResult = new ShoppingResult();
        OrderResult orderResult = new OrderResult();
        orderResult.setBuyerId(reqDTO.getBuyerId());
        shoppingResult.getOrderResults().add(orderResult);

        orderResult.getOrderLineResults().addAll(orderLineSpecs.stream().map(p -> initOrderLineResult(orderResult, p))
                .collect(Collectors.toList()));
        return shoppingResult;
    }

    private OrderLineResult initOrderLineResult(OrderResult orderResult, OrderLineSpec orderLineSpec) {
        OrderLineResult orderLineResult = new OrderLineResult();
        orderLineResult.setOrderId(orderResult.getOrderId());
        orderLineResult.setOrderLineSpec(orderLineSpec);
        return orderLineResult;
    }

    private OrderLineSpec buildOrderLineSpec(String buyerId, BuyItemDTO buyItemDTO, Map<String, String> requestParams) {
        OrderLineSpec orderLineSpec = new OrderLineSpec();
        orderLineSpec.getRequestParams().putAll(requestParams);
        orderLineSpec.setBuyerId(buyerId);
        BuyItemSpec item = new BuyItemSpec();
        orderLineSpec.setItem(item);
        item.setItemId(buyItemDTO.getItemId());
        item.setBuyQuantity(buyItemDTO.getBuyQuantity());
        item.getFeatures().putAll(buyItemDTO.getExtraParams());
        item.setUnitPrice(new BigDecimal(10000L));// from db
        return orderLineSpec;
    }
}
