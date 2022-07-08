package com.magician.configure;

import com.magician.configure.load.LoadConfig;
import com.magician.configure.load.constant.ReadMode;

public class MagicianConfigure {

    private static LoadConfig loadConfig = new LoadConfig();

    public static void load(String path, ReadMode readMode) throws Exception {
        loadConfig.load(path, readMode);
    }
}
