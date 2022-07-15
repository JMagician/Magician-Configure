package com.magician.configure;

import com.magician.configure.load.LoadConfig;
import com.magician.configure.load.constant.ReadMode;

/**
 * The main class, the interface for developers to use
 */
public class MagicianConfigure {

    private static LoadConfig loadConfig = new LoadConfig();

    /**
     * Loading configuration files
     * @param path
     * @param readMode
     * @throws Exception
     */
    public static void load(String path, ReadMode readMode) throws Exception {
        loadConfig.load(path, readMode);
    }
}
