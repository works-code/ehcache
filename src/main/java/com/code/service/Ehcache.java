package com.code.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Ehcache {

    /***
     * Cacheable
     * - 해당 키값이 존재할 경우, 메서드 수행하지 않고 키에 매핑된 값을 리턴
     * - 해당 키값이 존재하지 않는 경우, 수행하여 retuen 값 해당 key값으로 캐싱
     * cacheName : 캐시명
     * key : 캐시를 저장할 키
     * condition : 해당 조건에 맞으면 캐싱을 한다.
     * @param key
     * @param context
     */
    @Cacheable(cacheNames = "codeCache", key = "#key", condition = "#key != '' ")
    public String addCache(String key, String context){
        log.error("### cache add {} -> {}", key, context);
        return context;
    }

    // key에 해당하는 캐시만 제거
    @CacheEvict(cacheNames = "codeCache", key = "#key")
    public void deleteCache(String key){
        log.error("### cache delete -> {}",key);
    }

    // 모든 캐시 제거
    @CacheEvict(cacheNames = "codeCache", allEntries = true)
    public void deleteAllCache(){
        log.error("### all cache delete");
    }

    // 무조건 캐시 등록
    @CachePut(cacheNames = "codeCache", key = "#key", condition = "#key != '' ")
    public String updateCache(String key, String context){
        log.error("### cache add {} -> {}", key, context);
        return context;
    }
}
