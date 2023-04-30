package org.hiforce.sample.product;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.Product;
import org.hiforce.lattice.model.business.ProductTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.sample.scenario.placeorder.session.request.PlaceOrderScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2023/4/30
 */
@Product(code = SampleProductA.CODE, name = "Sample Product A")
public class SampleProductA extends ProductTemplate {

    public static final String CODE = "SampleProductA";
    @Override
    public boolean isEffect(ScenarioRequest request) {
        if (request instanceof PlaceOrderScenarioRequest) {
            return isEffect((PlaceOrderScenarioRequest) request);
        }
        return false;
    }

    private boolean isEffect(PlaceOrderScenarioRequest request) {
        String isPreSaleOpen = request.getOrderLine().getRequestParams().get("product_a");
        return StringUtils.equals(isPreSaleOpen, "1");
    }
}
