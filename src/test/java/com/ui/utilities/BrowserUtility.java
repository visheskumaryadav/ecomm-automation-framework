package com.ui.utilities;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver =new ThreadLocal<>();

    public BrowserUtility(){
        driver.set(new ChromeDriver());
    }
    public BrowserUtility(WebDriver driver){
        this.driver.set(driver);
    }

    public BrowserUtility(Browser browser){
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

    protected WebDriver getDriver() {
        return driver.get();
    }

    protected void goToWebsite(String url){
        driver.get().get(url);
    }
    protected void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
    protected void enterInTextBox(By locator,String textToWrite){
        driver.get().findElement(locator).sendKeys(textToWrite);
    }
    protected String getPageTitle(){
        return driver.get().getTitle();
    }
    protected void selectRadioBtn(By locator){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
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

    protected boolean isElementVisible(By locator) {
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
