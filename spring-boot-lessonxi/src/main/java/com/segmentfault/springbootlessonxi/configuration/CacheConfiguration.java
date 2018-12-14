package com.segmentfault.springbootlessonxi.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-13 13:02
 **/
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager(){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");//必须要有cache名称
        ConcurrentMapCache persons = new ConcurrentMapCache("persons");//必须要有cache名称
        simpleCacheManager.setCaches(Arrays.asList(cache,persons));
        return simpleCacheManager;
    }
}
