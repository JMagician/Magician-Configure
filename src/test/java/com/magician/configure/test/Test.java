package com.magician.configure.test;

import com.magician.configure.MagicianConfigure;
import com.magician.configure.env.Environment;
import com.magician.configure.load.constant.ReadMode;

public class Test {

    public static void main(String[] args) {
        try {
            MagicianConfigure.load("/application.properties", ReadMode.LOCAL);

            System.out.println(Environment.get("user.name"));

            System.out.println(Environment.get("JAVA_HOME"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
