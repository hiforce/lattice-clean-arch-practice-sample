package org.hiforce.sample.trade.service;

import org.hiforce.sample.trade.ability.orderline.TradeOrderLineInitAbility;
import org.hiforce.sample.trade.ability.orderline.TradeOrderLineSaveAbility;
import org.hiforce.sample.trade.model.TradeOrderDO;
import org.hiforce.sample.trade.model.dto.OrderDTO;
import org.hiforce.sample.trade.model.dto.OrderLineDTO;
import org.hiforce.sample.trade.model.spec.BuyItemSpec;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Service
public class TradeServiceImpl implements TradeService {


    @Override
    public List<OrderLineSpec> initBuildOrderLines(List<OrderLineSpec> originOrderLines) {
        initOrderLineUnitPrice(originOrderLines);
        return originOrderLines;
    }

    private void initOrderLineUnitPrice(List<OrderLineSpec> orderLines) {
        for (OrderLineSpec orderLine : orderLines) {
            TradeOrderLineInitAbility ability = new TradeOrderLineInitAbility(orderLine);
            ability.initOrderLineUnitPrice();
        }
    }


    private OrderLineSpec buildOrderLineSpec(OrderDTO orderDTO, OrderLineDTO orderLineDTO) {
        OrderLineSpec orderLineSpec = new OrderLineSpec();
        orderLineSpec.getRequestParams().putAll(orderLineDTO.getRequestParams());
        orderLineSpec.setBuyerId(orderDTO.getBuyerId());
        orderLineSpec.getAttributes().putAll(orderLineDTO.getAttributes());
        BuyItemSpec item = new BuyItemSpec();
        orderLineSpec.setItem(item);
        item.setItemId(orderLineDTO.getItemId());
        item.setBuyQuantity(orderLineDTO.getBuyQuantity());
        item.getFeatures().putAll(orderLineDTO.getItemFeatures());
        item.setUnitPrice(new BigDecimal(orderLineDTO.getUnitPrice()));
        return orderLineSpec;
    }

    @Override
    public TradeOrderDO saveTradeOrder(OrderDTO orderDTO) {
        //do something before saving...
        List<OrderLineSpec> orderLineSpecs = orderDTO.getOrderLines().stream()
                .map(p -> buildOrderLineSpec(orderDTO, p))
                .collect(Collectors.toList());

        orderLineSpecs.forEach(this::processOrderLineBeforeSaving);
        //do saving...bla..bla..bla..

        //do something after saving...
        orderLineSpecs.forEach(this::processOrderLineAfterSaving);
        return new TradeOrderDO();
    }

    private void processOrderLineBeforeSaving(OrderLineSpec orderLine) {
        TradeOrderLineSaveAbility ability = new TradeOrderLineSaveAbility(orderLine);
        orderLine.getAttributes().putAll(ability.getCustomOrderLineAttributes());
        ability.processOrderLineBeforeSaving();
    }

    private void processOrderLineAfterSaving(OrderLineSpec orderLine) {
        TradeOrderLineSaveAbility ability = new TradeOrderLineSaveAbility(orderLine);
        ability.finalProcessOrderLineAfterSaving();
    }
}
