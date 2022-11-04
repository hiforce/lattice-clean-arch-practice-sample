package org.hiforce.sample.scenario.placeorder.service.param;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.sample.trade.model.dto.OrderDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class RenderOrderRespDTO implements Serializable {

    private static final long serialVersionUID = -7590897152867893816L;

    @Getter
    @Setter
    private boolean success;

    @Getter
    @Setter
    private String errCode;

    @Getter
    @Setter
    private String errTest;

    @Getter
    private final List<OrderDTO> orders = Lists.newArrayList();
}
