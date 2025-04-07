package com.example;

import org.example.matchingengine.config.RedisConfig;
import org.example.matchingengine.service.MarketDataStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = {RedisConfig.class })
class CacheConfigurationTest {

    //@Autowired(required = false)
    //private CacheManager cacheManager;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        //assertThat(cacheManager).isNotNull();
        assertThat(redisTemplate).isNotNull();
    }
}