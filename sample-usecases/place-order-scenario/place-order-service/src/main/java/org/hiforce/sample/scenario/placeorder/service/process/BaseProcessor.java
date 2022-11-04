package org.hiforce.sample.scenario.placeorder.service.process;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public abstract class BaseProcessor<R, T> {

    public abstract R process(R r, T t);
}
