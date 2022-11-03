package org.hiforce.sample.scenario.placeorder.service;

import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderRespDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderRespDTO;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public interface PlaceOrderService {

    /**
     * render order service, build order info for buyer to confirm.
     *
     * @param reqDTO RenderOrderReqDTO
     * @return RenderOrderRespDTO
     */
    RenderOrderRespDTO renderOrder(RenderOrderReqDTO reqDTO);

    /**
     * create the order once buyer confirmed.
     *
     * @param reqDTO CreateOrderReqDTO
     * @return CreateOrderRespDTO
     */
    CreateOrderRespDTO createOrder(CreateOrderReqDTO reqDTO);
}
