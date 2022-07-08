package com.magician.configure.load;

import com.magician.configure.load.cache.ConfigCacheManager;
import com.magician.configure.load.constant.ReadMode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class LoadConfig {

    public void load(String path, ReadMode readMode) throws Exception {
        InputStream inputStream = getFileContent(path, readMode);

        try {
            Properties p = new Properties();
            p.load(inputStream);

            for(Object key : p.keySet()){
                String keyStr = key.toString();
                ConfigCacheManager.add(keyStr, p.getProperty(keyStr));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
    }

    private InputStream getFileContent(String path, ReadMode readMode) throws Exception {
        switch (readMode) {
            case LOCAL:
                return LoadConfig.class.getResourceAsStream(path);
            case EXTERNAL:
                return new FileInputStream(path);
            case REMOTE:
                URL url = new URL(path);
                URLConnection urlConnection = url.openConnection();
                return urlConnection.getInputStream();
        }
        return null;
    }
}
