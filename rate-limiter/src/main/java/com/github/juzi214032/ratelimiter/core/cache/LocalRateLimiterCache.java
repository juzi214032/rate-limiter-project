package com.github.juzi214032.ratelimiter.core.cache;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Juzi
 * @since  2020/7/27 17:08
 */
@Component
public class LocalRateLimiterCache implements RateLimiterCache {

    @Autowired
    private Cache<String,String> cache;

    @Override
    public boolean put(String key) {

        return false;
    }
}
