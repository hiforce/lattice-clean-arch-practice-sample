package org.hiforce.sample.trade.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class MainOrderDO implements Serializable {

    private static final long serialVersionUID = 1960463205746390482L;

    @Getter
    @Setter
    private long orderId;

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    @Getter
    private final List<OrderLineDO> orderLine = Lists.newArrayList();
}
