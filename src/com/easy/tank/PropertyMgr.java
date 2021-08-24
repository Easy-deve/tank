package com.easy.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/24 17:24
 */
public class PropertyMgr {

    public static Properties props = new Properties();

    static {
        init();
    }
    public static void init() {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) {
            props = new Properties();
            init();
        }
        return props.getProperty(key).trim();
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(String.valueOf(PropertyMgr.get("initTankCounts"))));
    }
}
