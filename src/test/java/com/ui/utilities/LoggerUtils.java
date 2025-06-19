package com.ui.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerUtils {

    public static Logger logger(Class<?> clazz){
            return LogManager.getLogger(clazz);
    }
}
