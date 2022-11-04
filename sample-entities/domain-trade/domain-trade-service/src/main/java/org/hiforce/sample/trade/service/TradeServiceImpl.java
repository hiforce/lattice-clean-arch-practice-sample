package org.hiforce.sample.trade.service;

import org.hiforce.sample.trade.ability.orderline.TradeOrderLineSaveAbility;
import org.hiforce.sample.trade.model.OrderLineDO;
import org.hiforce.sample.trade.model.TradeOrderDO;
import org.springframework.stereotype.Service;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Override
    public TradeOrderDO saveTradeOrder(TradeOrderDO tradeOrderDO) {

        //do something before saving...
        tradeOrderDO.getBizOrder().getOrderLine()
                .forEach(this::processOrderLineBeforeSaving);

        //do saving...bla..bla..bla..

        //do something after saving...
        tradeOrderDO.getBizOrder().getOrderLine()
                .forEach(this::processOrderLineAfterSaving);

        return tradeOrderDO;
    }

    private void processOrderLineBeforeSaving(OrderLineDO orderLine) {
        TradeOrderLineSaveAbility ability = new TradeOrderLineSaveAbility(orderLine);
        orderLine.getAttributes().putAll(ability.getCustomOrderLineAttributes());
        ability.processOrderLineBeforeSaving();
    }

    private void processOrderLineAfterSaving(OrderLineDO orderLine) {
        TradeOrderLineSaveAbility ability = new TradeOrderLineSaveAbility(orderLine);
        ability.finalProcessOrderLineAfterSaving();
    }
}
