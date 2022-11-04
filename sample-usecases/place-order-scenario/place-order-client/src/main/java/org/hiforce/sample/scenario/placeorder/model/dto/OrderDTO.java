package org.hiforce.sample.scenario.placeorder.model.dto;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -4169357658226724601L;

    @Getter
    private final List<OrderLineDTO> orderLines = Lists.newArrayList();
}
