package org.hiforce.sample.trade.model.spec;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class BuyItemSpec implements Serializable {

    private static final long serialVersionUID = 491032792497581075L;

    @Getter
    @Setter
    private String itemId;

    @Getter
    @Setter
    private int buyQuantity;

    @Getter
    @Setter
    private BigDecimal unitPrice;

    @Getter
    private final Map<String, String> features = Maps.newHashMap();
}
