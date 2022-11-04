package org.hiforce.sample.presale.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public class PreSaleInfo implements Serializable {

    private static final long serialVersionUID = -158141328719637358L;

    @Getter
    @Setter
    private BigDecimal ratio;
}
