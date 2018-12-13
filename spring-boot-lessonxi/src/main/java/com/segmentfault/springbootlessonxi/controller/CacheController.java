package com.segmentfault.springbootlessonxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-13 12:45
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    @Qualifier("simpleCacheManager")
    private CacheManager cacheManager;

    @PostMapping("/save")
    public Map<String,Object> save(@RequestParam String key, @RequestParam String value){
        Cache cache = cacheManager.getCache("cache-1");

        cache.put(key,value);

        Map<String,Object> result = new HashMap<>();

        result.put(key,value);

        return result;
    }
}
