package com.github.juzi214032.ratelimiter.autoconfigure.annotation;

import com.github.juzi214032.ratelimiter.autoconfigure.configuration.RateLimiterAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启 RateLimiter 限频
 *
 * @author Juzi
 * @since 2020/7/27 13:51
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RateLimiterAutoConfiguration.class)
public @interface EnableRateLimiter {
}
