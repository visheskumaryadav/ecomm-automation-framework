package com.ui.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

    public static void setUp(String reportName){
        String reportPath=System.getProperty("user.dir") + "//" + reportName;
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(reportPath);
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void createExtentTest(String testName){
        extentTest.set(extentReports.createTest(testName));
    }
    public static ExtentTest getTest(){
        return extentTest.get();
    }
    public static void flushReport() {
        extentReports.flush();
    }

}
