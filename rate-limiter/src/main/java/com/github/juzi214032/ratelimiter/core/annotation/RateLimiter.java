package com.github.juzi214032.ratelimiter.core.annotation;

import com.github.juzi214032.ratelimiter.core.constant.DimensionConstant;
import com.github.juzi214032.ratelimiter.core.factory.DimensionFactory;
import com.github.juzi214032.ratelimiter.core.factory.IPDimensionFactory;

/**
 * 限频注解
 *
 * @author Juzi
 * @since 2020/7/27 11:48
 */
public @interface RateLimiter {

    /**
     * 限频纬度
     */
    DimensionConstant dimension() default DimensionConstant.IP;

    /**
     * 限频纬度实现类
     */
    Class<? extends DimensionFactory> dimensionFactory() default IPDimensionFactory.class;

    /**
     * 限频时间，单位：秒
     */
    long duration() default 1;

    /**
     * 限频频率
     */
    int frequency() default 3;

    /**
     * 限频提示信息
     */
    String message() default "操作过于频繁，请稍候再试";

}
