package com.magician.configure.test;

import com.magician.configure.MagicianConfigure;
import com.magician.configure.env.Environment;
import com.magician.configure.load.constant.ReadMode;

public class Test {

    public static void main(String[] args) {
        try {
            MagicianConfigure.load("/home/xxx/application.map", ReadMode.EXTERNAL);

            String userName = Environment.get("userName");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
