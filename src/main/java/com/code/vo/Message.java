package com.code.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class Message {

    private CacheMode cacheMode;
    private String key;
    private String context;

    public void setCacheMode(String mode) {
        if(StringUtils.isNotEmpty(mode)){
            if(StringUtils.equalsAnyIgnoreCase(mode,"add")){
                cacheMode = CacheMode.ADD;
            }else if(StringUtils.equalsAnyIgnoreCase(mode,"update")){
                cacheMode = CacheMode.UPDATE;
            }else if(StringUtils.equalsAnyIgnoreCase(mode,"delete")){
                cacheMode = CacheMode.DELETE;
            }else if(StringUtils.equalsAnyIgnoreCase(mode,"alldelete")){
                cacheMode = CacheMode.ALLDELETE;
            }else{
                cacheMode = CacheMode.ADD;
            }
        }else{
            cacheMode = CacheMode.ADD;
        }
    }
}
