package org.hiforce.sample.trade.ext.orderline.check;

import org.hiforce.lattice.annotation.Schema;
import org.hiforce.lattice.model.ability.BusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
@Schema(root = true)
public class BlankTradeOrderLineCheckExt extends BusinessExt implements TradeOrderLineCheckExt {
}
