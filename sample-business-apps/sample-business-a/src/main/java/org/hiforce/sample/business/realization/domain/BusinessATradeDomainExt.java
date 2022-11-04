package org.hiforce.sample.business.realization.domain;

import com.google.common.collect.Maps;
import org.hiforce.lattice.annotation.Realization;
import org.hiforce.sample.business.SampleBusinessA;
import org.hiforce.sample.trade.ext.BlankTradeEntityExt;
import org.hiforce.sample.trade.ext.orderline.BlankTradeOrderLineExt;
import org.hiforce.sample.trade.ext.orderline.save.BlankTradeOrderLineSaveExt;
import org.hiforce.sample.trade.ext.orderline.save.param.SaveOrderLineExtInput;

import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Realization(codes = SampleBusinessA.CODE)
public class BusinessATradeDomainExt extends BlankTradeEntityExt {
    @Override
    public BlankTradeOrderLineExt getTradeOrderLineExt() {
        return new BlankTradeOrderLineExt() {
            @Override
            public BlankTradeOrderLineSaveExt getTradeOrderLineSaveExt() {
                return new BlankTradeOrderLineSaveExt() {
                    @Override
                    public Map<String, String> getCustomOrderLineAttributes(SaveOrderLineExtInput input) {
                        Map<String, String> attributes = Maps.newHashMap();
                        attributes.put("business_a", "effective");
                        return attributes;
                    }
                };
            }
        };
    }
}
