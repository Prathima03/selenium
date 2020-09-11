package com.bitsai.testcases;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest extends Object{
    public SeleniumGridTest(){
        super();
    }

    WebDriver driver;
    String appURL = "https://parabank.parasoft.com/parabank/index.htm";

    @Test(priority = 1)

    public void setUp() throws MalformedURLException {
        String nodeURL = "http://192.168.4.39:4443/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);

        System.setProperty("webdriver.chrome.driver", "C:/Users/Ravi/Drivers/Chrome/chromedriver.exe");
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);

        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
    }

   /* @Test(priority = 2)
    public void login() {
        driver.get(appURL);
        String strTitle = driver.getTitle();
        if (strTitle.contains("ParaBank")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }*/

    //  seleniumgrid grid = new seleniumgrid(driver);
        //grid.cusRegister();


    @Test(priority = 2)

    public void loginApp() {
    driver.get(appURL);
        Assert.assertEquals("ParaBank", driver.getTitle());

        driver.close();
    }


}
