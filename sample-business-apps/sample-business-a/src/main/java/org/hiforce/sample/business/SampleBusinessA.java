package org.hiforce.sample.business;

import org.hiforce.lattice.annotation.Business;
import org.hiforce.lattice.model.business.BusinessTemplate;
import org.hiforce.lattice.model.scenario.ScenarioRequest;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Business(code = SampleBusinessA.CODE, name = "Business A")
public class SampleBusinessA extends BusinessTemplate {

    public static final String CODE = "SampleBusinessA";

    @Override
    public boolean isEffect(ScenarioRequest request) {
        return true;
    }
}
