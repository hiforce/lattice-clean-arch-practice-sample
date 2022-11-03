package org.hiforce.sample.scenario.placeorder.model.dto;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class BuyItemDTO implements Serializable {

    private static final long serialVersionUID = -1091121474319518519L;

    @Getter
    @Setter
    private String itemId;

    @Getter
    @Setter
    private int buyQuantity;

    @Getter
    @Setter
    private String memo;

    @Getter
    @Setter
    private String source;

    @Getter
    private final Map<String, String> extraParams = Maps.newHashMap();
}
