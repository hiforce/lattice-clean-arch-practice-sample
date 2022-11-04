package org.hiforce.sample.presale.realization;

import com.google.common.collect.Maps;
import org.hiforce.lattice.annotation.Realization;
import org.hiforce.sample.presale.PreSaleUseCaseCapability;
import org.hiforce.sample.presale.ability.PreSaleOrderLineSaveAbility;
import org.hiforce.sample.presale.model.PreSaleInfo;
import org.hiforce.sample.presale.model.PreSaleOrderLine;
import org.hiforce.sample.trade.ext.BlankTradeEntityExt;
import org.hiforce.sample.trade.ext.orderline.BlankTradeOrderLineExt;
import org.hiforce.sample.trade.ext.orderline.init.BlankTradeOrderLineInitExt;
import org.hiforce.sample.trade.ext.orderline.init.param.InitOrderLineExtInput;
import org.hiforce.sample.trade.ext.orderline.save.BlankTradeOrderLineSaveExt;
import org.hiforce.sample.trade.ext.orderline.save.param.SaveOrderLineExtInput;
import org.hiforce.sample.trade.model.spec.OrderLineSpec;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Realization(codes = PreSaleUseCaseCapability.CODE)
public class PreSaleTradeExt extends BlankTradeEntityExt {

    @Override
    public BlankTradeOrderLineExt getTradeOrderLineExt() {
        return new BlankTradeOrderLineExt() {

            @Override
            public BlankTradeOrderLineInitExt getTradeOrderLineInitExt() {
                return new BlankTradeOrderLineInitExt() {
                    @Override
                    public BigDecimal getCustomUnitPrice(InitOrderLineExtInput input) {
                        BigDecimal ratio = getCustomPreSalePayRatio(input.getOrderLine());
                        return input.getOrderLine().getItem().getUnitPrice().multiply(ratio);
                    }
                };
            }

            @Override
            public BlankTradeOrderLineSaveExt getTradeOrderLineSaveExt() {
                return new BlankTradeOrderLineSaveExt() {
                    @Override
                    public Map<String, String> getCustomOrderLineAttributes(SaveOrderLineExtInput input) {
                        Map<String, String> attributes = Maps.newHashMap();
                        BigDecimal ratio = getCustomPreSalePayRatio(input.getOrderLine());
                        DecimalFormat df = new DecimalFormat("#.00");
                        String value = df.format(ratio);
                        System.out.println("[UseCase]PreSaleTrade load custom down payment ratio: " + value);
                        attributes.put("presale_ratio", value);
                        return attributes;
                    }
                };
            }
        };
    }

    private BigDecimal getCustomPreSalePayRatio(OrderLineSpec orderLineSpec) {
        PreSaleInfo preSaleInfo = orderLineSpec.getExtObject(PreSaleInfo.class);
        if (null != preSaleInfo && null != preSaleInfo.getRatio()) {
            return preSaleInfo.getRatio();
        }

        PreSaleOrderLine orderLine = buildPreSaleOrderLine(orderLineSpec);
        PreSaleOrderLineSaveAbility ability = new PreSaleOrderLineSaveAbility(orderLine);
        return ability.getCustomDownPaymentRatio();
    }

    private PreSaleOrderLine buildPreSaleOrderLine(OrderLineSpec orderLine) {
        PreSaleOrderLine preSaleOrderLine = new PreSaleOrderLine();
        preSaleOrderLine.setOrderLineId(orderLine.getOrderLineId());
        preSaleOrderLine.setScenario(orderLine.getScenario());
        preSaleOrderLine.setBizCode(orderLine.getBizCode());
        preSaleOrderLine.setBuyQuantity(orderLine.getItem().getBuyQuantity());
        preSaleOrderLine.getAttributes().putAll(orderLine.getAttributes());
        return preSaleOrderLine;
    }
}
