package com.ui.utilities;

import com.constants.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BrowserUtility {
    private Logger logger= LoggerUtils.logger(this.getClass());
    private static ThreadLocal<WebDriver> driver =new ThreadLocal<>();

    public BrowserUtility(){
        logger.info("Launching chrome browser");
        driver.set(new ChromeDriver());
    }
    public BrowserUtility(WebDriver driver){
        this.driver.set(driver);
    }

    public BrowserUtility(Browser browser){
        logger.info("Launching browser "+browser);
        if(browser==Browser.CHROME){
            driver.set(new ChromeDriver());
        }else if(browser==Browser.EDGE){
            driver.set(new EdgeDriver());
        }
    }
    public BrowserUtility(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
        }else if(browserName.equalsIgnoreCase("edge")){
            driver.set(new EdgeDriver());
        }else{
            System.err.println("Invalid browser name");
        }
    }
    public BrowserUtility(Browser browser,boolean isHeadLess){
        logger.info("Launching browser "+browser);
        if(browser==Browser.CHROME){
            if(isHeadLess){
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--headless");
                driver.set(new ChromeDriver(options));
            }else {
                driver.set(new ChromeDriver());
            }
        }else if(browser==Browser.EDGE){
            if(isHeadLess){
                EdgeOptions options=new EdgeOptions();
                options.addArguments("--headless");
                driver.set(new EdgeDriver(options));
            }else {
                driver.set(new EdgeDriver());
            }
        }
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    protected void goToWebsite(String url){
        driver.get().get(url);
        logger.info(">>>>>><<<<<<<<<<< URL::"+url);
    }
    protected void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
    protected void click(WebElement webElement){
        webElement.click();
    }
    protected void enterInTextBox(By locator,String textToWrite){
        driver.get().findElement(locator).sendKeys(textToWrite);
    }
    protected String getPageTitle(){
        return driver.get().getTitle();
    }
    protected void selectRadioBtn(By locator){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
        WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(locator));
        radioBtn.click();
    }
    public void closeTab(){
        driver.get().close();
    }
    public void quitBrowser(){
        driver.get().quit();
    }

    protected WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator){
//        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(locator));
        return driver.get().findElements(locator);
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    protected  void clear(By locator){
        driver.get().findElements(locator).clear();
    }
    protected void selectDropdown(By locator, String sizeText){
        Select dropdown = new Select(driver.get().findElement(locator));
        dropdown.selectByVisibleText(sizeText);
    }
//    protected boolean isVisible(By locator) {
//        return driver.get().findElement(locator).isDisplayed();
//    }
}
