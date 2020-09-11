package com.onlineshopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutamationPractice {
    WebDriver driver;

    public void launchBrowser(){

        System.setProperty("webdriver.gecko.driver","C:/Users/Ravi/Drivers/Firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        String pgTitle = driver.getTitle();// getting page title
        System.out.println("Home Page Title :"+pgTitle);

    }

    public void pgNavigation(){
        driver.findElement(By.partialLinkText("Sign")).click();
        String lgnpgTitle = driver.getTitle();
        System.out.println("Login Page Title :"+lgnpgTitle);

    }

    public void createAccount() throws InterruptedException {

        driver.findElement(By.cssSelector("#email_create")).sendKeys("test.@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);
        String crtAccErrMsg = driver.findElement(By.xpath("//div[@id='create_account_error']")).getText();
        Thread.sleep(3000);
        System.out.println("Create Account Error Msg :"+crtAccErrMsg);


    }

    public void closeBrowser(){
        driver.quit();
    }




    public static void main(String[] args) throws InterruptedException {
        AutamationPractice ap = new AutamationPractice();
        ap.launchBrowser();
        ap.pgNavigation();
        ap.createAccount();
        ap.closeBrowser();

    }
}
