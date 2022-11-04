package org.hiforce.sample.trade.model.spec;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.sequence.SequenceGenerator;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/3
 */
public class OrderLineSpec implements IBizObject {

    @Getter
    @Setter
    private long orderLineId = SequenceGenerator.next(OrderLineSpec.class.getName());

    @Getter
    @Setter
    private String bizCode;

    @Getter
    @Setter
    private String scenario;

    @Getter
    @Setter
    private String buyerId;

    @Getter
    @Setter
    private BuyItemSpec item;

    @Getter
    private final Map<String, String> attributes = Maps.newHashMap();

    @Getter
    private final Map<String, String> requestParams = Maps.newHashMap();

    @Override
    public BizContext getBizContext() {

        return new BizContext() {

            private static final long serialVersionUID = 1129296801641509441L;

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
