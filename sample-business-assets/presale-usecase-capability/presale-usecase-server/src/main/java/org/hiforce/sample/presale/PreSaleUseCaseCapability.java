package org.hiforce.sample.presale;

import org.apache.commons.lang3.StringUtils;
import org.hiforce.lattice.annotation.UseCase;
import org.hiforce.lattice.model.business.UseCaseTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;
import org.hiforce.sample.scenario.placeorder.session.request.PlaceOrderScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@UseCase(
        code = PreSaleUseCaseCapability.CODE,
        name = "PreSale Trade UseCase Capability",
        sdk = BlankPreSaleTradeExt.class
)
public class PreSaleUseCaseCapability extends UseCaseTemplate {

    public static final String CODE = "PreSaleUseCaseCapability";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        if (request instanceof PlaceOrderScenarioRequest) {
            return isEffect((PlaceOrderScenarioRequest) request);
        }
        return false;
    }

    private boolean isEffect(PlaceOrderScenarioRequest request) {
        String isPreSaleOpen = request.getOrderLine().getRequestParams().get("presale_open");
        return StringUtils.equals(isPreSaleOpen, "1");
    }
}
