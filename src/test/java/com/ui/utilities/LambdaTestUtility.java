package com.ui.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<>();

    public static WebDriver initializeLambdaTestSession(String browserName, String testName)  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "137");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "dacc7576");
        ltOptions.put("accessKey", "LT_YydpEoXHzllLcRk6iU5noH0FYr75sMhMQMAcdVAiOcW79Iw");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver =null;
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        driverLocal.set(driver);
        return driverLocal.get();
    }

    public static void quitSession(){
        if(driverLocal.get()!=null){
            driverLocal.get().quit();
        }
    }

}
