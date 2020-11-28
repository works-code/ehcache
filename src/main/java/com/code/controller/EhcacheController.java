package com.code.controller;

import com.code.service.Ehcache;
import com.code.vo.CacheMode;
import com.code.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EhcacheController {

    @Autowired
    Ehcache ehcache;

    /***
     * 캐싱된 값을 리턴하는 API
     * @param message
     * @return
     */
    @RequestMapping(value = "/cache")
    public Message add(Message message){

        if(message.getCacheMode() == CacheMode.ADD){
            message.setContext(ehcache.addCache(message.getKey(), message.getContext()));
        }

        if(message.getCacheMode() == CacheMode.UPDATE){
            message.setContext(ehcache.updateCache(message.getKey(), message.getContext()));
        }

        if(message.getCacheMode() == CacheMode.DELETE){
            ehcache.deleteCache(message.getKey());
        }

        if(message.getCacheMode() == CacheMode.ALLDELETE){
            ehcache.deleteAllCache();
        }

        return message;
    }

}
