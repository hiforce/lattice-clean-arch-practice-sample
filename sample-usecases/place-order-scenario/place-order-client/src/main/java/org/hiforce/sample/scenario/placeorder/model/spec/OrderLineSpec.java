package org.hiforce.sample.scenario.placeorder.model.spec;

import lombok.Getter;
import lombok.Setter;
import org.hiforce.lattice.model.business.BizContext;
import org.hiforce.lattice.model.business.IBizObject;
import org.hiforce.lattice.sequence.SequenceGenerator;

import java.io.Serializable;

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
