package com.ui.listeners;

import com.aventstack.extentreports.Status;
import com.ui.utilities.ExtentReportUtility;
import com.ui.utilities.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    private Logger logger= LoggerUtils.logger(this.getClass());
    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentReportUtility.getTest().log(Status.PASS,result.getMethod().getMethodName() + " " + "PASSED");
          }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "FAILED");
        ExtentReportUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName() + " " + "PASSED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentReportUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName() + " " + "PASSED");

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtility.setUp("extentReport.html");
        logger.info("Test Suite Started: "+context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtility.flushReport();
        logger.info("Test Suite Finished: "+context.getSuite().getName());
    }
}
