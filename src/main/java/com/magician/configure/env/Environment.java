package com.magician.configure.env;

import com.magician.configure.load.cache.ConfigCacheManager;

import java.util.Map;

public class Environment {

    private static Map<String, String> configMap = ConfigCacheManager.getConfigMap();
    public static String get(String key){
        String value = configMap.get(key);
        if(value == null){
            value = System.getenv(key);
        }
        return value;
    }
}
