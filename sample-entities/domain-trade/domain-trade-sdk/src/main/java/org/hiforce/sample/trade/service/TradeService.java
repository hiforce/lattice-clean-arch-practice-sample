package org.hiforce.sample.trade.service;

import org.hiforce.sample.trade.model.TradeOrderDO;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradeService {

    TradeOrderDO saveTradeOrder(TradeOrderDO tradeOrderDO);
}
