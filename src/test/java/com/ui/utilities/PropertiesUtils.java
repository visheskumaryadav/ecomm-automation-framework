package com.ui.utilities;


import java.io.*;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtils {
//reading properties file
    public static String readProperty(Env env, String propertyName){
        String filePath=System.getProperty("user.dir")+"//config//"+env+".properties";
        File file=new File(filePath);
        FileReader fileReader=null;
        Properties properties=null;
        try {
            fileReader = new FileReader(file);
            properties = new Properties();
            properties.load(fileReader);
        }catch (IOException e ) {
            e.printStackTrace();
        }
        assert properties != null;
        return properties.getProperty(propertyName.toUpperCase());
    }

}
