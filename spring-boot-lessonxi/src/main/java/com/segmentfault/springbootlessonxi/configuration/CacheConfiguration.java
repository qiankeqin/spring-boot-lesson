package com.segmentfault.springbootlessonxi.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-13 13:02
 **/
@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager(){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");//必须要有cache名称
        simpleCacheManager.setCaches(Collections.singleton(cache));
        return simpleCacheManager;
    }
}
