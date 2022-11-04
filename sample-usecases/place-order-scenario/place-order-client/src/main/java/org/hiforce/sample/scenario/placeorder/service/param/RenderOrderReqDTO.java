package org.hiforce.sample.scenario.placeorder.service.param;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.sample.trade.model.dto.BuyItemDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class RenderOrderReqDTO implements Serializable {

    private static final long serialVersionUID = -7094050186230716811L;

    @Getter
    @Setter
    private String buyerId;

    @Getter
    private final List<BuyItemDTO> items = Lists.newArrayList();

    @Getter
    private final Map<String, String> requestParams = Maps.newHashMap();
}
