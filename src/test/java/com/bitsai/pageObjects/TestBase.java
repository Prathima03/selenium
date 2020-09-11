package com.bitsai.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driverTB;
    public static Properties property;

    public TestBase(){
        property = new Properties();
        try {
    FileInputStream fip = new FileInputStream("C:/Users/Ravi/MavenAuto/src/main/resources/config.properties");
      property.load(fip);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static  void initialize(){
        String browser = property.getProperty("Browser");
    if ("Firefox".equals(browser))  {
        System.setProperty("webdriver.gecko.driver",property.getProperty("Firefox"));
        driverTB = new FirefoxDriver();
    }

    else if ("Chrome".equals(browser)){
        System.setProperty("webdriver.chrome.driver",property.getProperty("Chrome"));
        driverTB = new ChromeDriver();
    }

    else{
        System.setProperty("webdriver.edge.driver",property.getProperty("Edge"));
        driverTB = new EdgeDriver();
    }


    driverTB.manage().window().maximize();
    driverTB.manage().deleteAllCookies();
    driverTB.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driverTB.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driverTB.get(property.getProperty("appURL"));
    }
}
