package org.hiforce.sample.buynow.web.controller;

import org.hiforce.lattice.utils.JacksonUtils;
import org.hiforce.sample.scenario.placeorder.service.PlaceOrderService;
import org.hiforce.sample.scenario.placeorder.service.param.CreateOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderReqDTO;
import org.hiforce.sample.scenario.placeorder.service.param.RenderOrderRespDTO;
import org.hiforce.sample.trade.model.dto.BuyItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@RestController
@SuppressWarnings("all")
public class BuyNowWebController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @RequestMapping("/buy/1")
    public String doBuyItem_1() {
        RenderOrderReqDTO reqDTO = new RenderOrderReqDTO();
        reqDTO.setBuyerId("rocky");
        reqDTO.getItems().add(BuyItemDTO.of("2919311334001001", 1));
        reqDTO.getRequestParams().put("presale_open", "1");
        RenderOrderRespDTO respDTO = placeOrderService.renderOrder(reqDTO);


        CreateOrderReqDTO createOrderReqDTO = new CreateOrderReqDTO();
        createOrderReqDTO.setBuyerId(reqDTO.getBuyerId());
        createOrderReqDTO.getRequestParams().putAll(reqDTO.getRequestParams());
        createOrderReqDTO.getOrders().addAll(respDTO.getOrders());
        placeOrderService.createOrder(createOrderReqDTO);

        return JacksonUtils.serializeWithoutException(respDTO);
    }

    @RequestMapping("/buy/2")
    public String doBuyItem_2() {
        RenderOrderReqDTO reqDTO = new RenderOrderReqDTO();
        reqDTO.setBuyerId("rocky");
        reqDTO.getItems().add(BuyItemDTO.of("2919311334001001", 1));
        RenderOrderRespDTO respDTO = placeOrderService.renderOrder(reqDTO);


        CreateOrderReqDTO createOrderReqDTO = new CreateOrderReqDTO();
        createOrderReqDTO.setBuyerId(reqDTO.getBuyerId());
        createOrderReqDTO.getRequestParams().putAll(reqDTO.getRequestParams());
        createOrderReqDTO.getOrders().addAll(respDTO.getOrders());
        placeOrderService.createOrder(createOrderReqDTO);

        return JacksonUtils.serializeWithoutException(respDTO);
    }
}
