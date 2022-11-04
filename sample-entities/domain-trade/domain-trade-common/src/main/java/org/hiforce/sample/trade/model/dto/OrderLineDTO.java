package org.hiforce.sample.trade.model.dto;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class OrderLineDTO implements Serializable {

    private static final long serialVersionUID = -8311413037848018561L;

    @Getter
    @Setter
    private long orderLineId;

    @Getter
    @Setter
    private String itemId;

    @Getter
    @Setter
    private int buyQuantity;

    @Getter
    @Setter
    private long unitPrice;

    @Getter
    private final Map<String, String> itemFeatures = Maps.newHashMap();

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    @Getter
    private final Map<String, String> requestParams = Maps.newHashMap();
}
