package com.isspark.study.properties;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils{
    private static String PROP_PATH = "src/main/resources/app.properties";

    public static String get(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        Object obj = getPropFile().get(key);
        if(obj==null){
            return null;
        }
        return obj.toString();
    }
    public static Properties getPropFile(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROP_PATH));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
