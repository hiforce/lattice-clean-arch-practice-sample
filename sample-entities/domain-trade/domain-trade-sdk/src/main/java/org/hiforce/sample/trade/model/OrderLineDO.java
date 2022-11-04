package org.hiforce.sample.trade.model;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class OrderLineDO implements IBizObject, Serializable {

    private static final long serialVersionUID = -8984577494569729211L;

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private long orderLineId;

    @Getter
    @Setter
    private String bizCode;

    @Getter
    @Setter
    private String scenario;

    @Getter
    @Setter
    private int buyQuantity;

    @Getter
    @Setter
    private long unitPrice;

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    @Override
    public BizContext getBizContext() {

        return new BizContext() {

            private static final long serialVersionUID = 2931606663500131639L;

            @Override
            public Serializable getBizId() {
                return orderLineId;
            }

            @Override
            public String getBizCode() {
                return bizCode;
            }

            @Override
            public String getScenario() {
                return scenario;
            }
        };
    }
}
