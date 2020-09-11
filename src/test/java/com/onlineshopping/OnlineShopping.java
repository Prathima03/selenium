package com.onlineshopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OnlineShopping {
    WebDriver driver;
    String pgTitle;

    public void launchBrowser(){
        System.setProperty("webdriver.gecko.driver","C:/Users/Ravi/Drivers/Firefox/geckodriver.exe");
      driver=new FirefoxDriver();
      driver.get("https://www.amazon.ca");
      pgTitle=driver.getTitle();
        System.out.println(pgTitle);

    }

    public static void main(String[] args) {
        OnlineShopping os = new OnlineShopping();
        os.launchBrowser();

    }
}