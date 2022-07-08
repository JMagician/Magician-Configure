package com.magician.configure.load.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigCacheManager {

    private static Map<String, String> configMap = new ConcurrentHashMap<>();

    public static Map<String, String> getConfigMap() {
        return configMap;
    }

    public static void add(String key, String value){
        configMap.put(key, value);
    }
}
