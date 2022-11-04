package org.hiforce.sample.trade.service;

import org.hiforce.sample.trade.model.TradeOrderDO;
import org.hiforce.sample.trade.model.dto.OrderDTO;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public interface TradeService {

    List<OrderLineSpec> initBuildOrderLines(List<OrderLineSpec> originOrderLines);

    TradeOrderDO saveTradeOrder(OrderDTO orderDTO);
}
