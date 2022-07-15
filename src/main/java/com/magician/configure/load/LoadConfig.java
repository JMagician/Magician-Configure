package com.magician.configure.load;

import com.magician.configure.load.cache.ConfigCacheManager;
import com.magician.configure.load.constant.ReadMode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * Configuration loading class
 */
public class LoadConfig {

    private final String CHARSET_NAME = "UTF-8";

    /**
     * Read the data from the configuration file into the cache
     * @param path
     * @param readMode
     * @throws Exception
     */
    public void load(String path, ReadMode readMode) throws Exception {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStream = getFileContent(path, readMode);
            inputStreamReader = new InputStreamReader(inputStream, CHARSET_NAME);

            Properties p = new Properties();
            p.load(inputStreamReader);

            for(Object key : p.keySet()){
                String keyStr = key.toString();
                String value = p.getProperty(keyStr);
                ConfigCacheManager.add(keyStr, value);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
    }

    /**
     * Read the configuration file into the stream
     * @param path
     * @param readMode
     * @return
     * @throws Exception
     */
    private InputStream getFileContent(String path, ReadMode readMode) throws Exception {
        switch (readMode) {
            case LOCAL:
                return LoadConfig.class.getResourceAsStream(path);
            case EXTERNAL:
                return new FileInputStream(path);
            case REMOTE:
                return new URL(path).openConnection().getInputStream();
        }
        return null;
    }
}
