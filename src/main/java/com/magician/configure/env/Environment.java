package com.magician.configure.env;

import com.magician.configure.load.cache.ConfigCacheManager;

import java.util.Map;

/**
 * Environment Variable Management
 */
public class Environment {

    /**
     * Caching of configuration data
     */
    private static Map<String, String> configMap = ConfigCacheManager.getConfigMap();

    /**
     * Get the data from the environment variables, preferring the configuration file if it is available
     * @param key
     * @return
     */
    public static String get(String key){
        String value = configMap.get(key);
        if(value == null){
            value = System.getenv(key);
        }
        return value;
    }
}
