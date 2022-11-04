package org.hiforce.sample.trade.model.spec;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class OrderSpec implements Serializable {

    private static final long serialVersionUID = -8024397337926258042L;

    @Getter
    @Setter
    private long orderId;

    @Getter
    @Setter
    private String buyerId;

    @Getter
    private final List<OrderLineSpec> orderLines = Lists.newArrayList();
}
