package com.github.juzi214032.ratelimiter.core.aop;

import com.github.juzi214032.ratelimiter.core.annotation.RateLimiter;
import com.github.juzi214032.ratelimiter.core.cache.RateLimiterCache;
import com.github.juzi214032.ratelimiter.core.constant.DimensionConstant;
import com.github.juzi214032.ratelimiter.core.factory.DimensionFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Juzi
 * @since 2020/7/27 15:29
 */
@Aspect
@Component
public class RateLimiterAOP {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RateLimiterCache rateLimiterCache;

    @Before(value = "@annotation(rateLimiterAnnotation)")
    public void rateLimite(RateLimiter rateLimiterAnnotation) throws IllegalAccessException, InstantiationException {
        // 限频策略
        DimensionConstant dimension = rateLimiterAnnotation.dimension();
        // 限频实现类
        Class<? extends DimensionFactory> dimensionFactory = rateLimiterAnnotation.dimensionFactory();
        // 限频持续时间
        long duration = rateLimiterAnnotation.duration();
        // 限频频率
        int frequency = rateLimiterAnnotation.frequency();
        // 异常信息
        String message = rateLimiterAnnotation.message();

        String key;
        if (dimension == DimensionConstant.IP) {
            key = request.getRemoteHost();
        } else if (dimension == DimensionConstant.CUSTOM) {
            DimensionFactory dimensionFactoryInstance = dimensionFactory.newInstance();
            key = dimensionFactoryInstance.getDimension();
        }


    }
}
