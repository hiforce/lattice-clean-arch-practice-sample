package org.hiforce.sample.scenario.placeorder.service.param;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.sample.trade.model.dto.OrderDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class CreateOrderReqDTO implements Serializable {

    private static final long serialVersionUID = -138443543765569395L;

    @Getter
    @Setter
    private String buyerId;

    @Getter
    private final List<OrderDTO> orders = Lists.newArrayList();

    @Getter
    private final Map<String, String> requestParams = Maps.newHashMap();
}
