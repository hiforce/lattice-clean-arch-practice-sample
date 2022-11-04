package org.hiforce.sample.scenario.placeorder.session.result;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.hiforce.sample.scenario.placeorder.session.result.order.OrderResult;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class ShoppingResult implements Serializable {

    private static final long serialVersionUID = 2987640510348064770L;

    @Getter
    private final List<OrderResult> orderResults = Lists.newArrayList();
}
