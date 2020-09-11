package com.onlineshopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 class AdvantageOnline{
    WebDriver driver;

    public void launchBrowser(){

    System.setProperty("webdriver.gecko.driver","C:/Users/Ravi/Drivers/Firefox/geckodriver.exe");
    driver = new FirefoxDriver();
    driver.get("http://www.advantageonlineshopping.com/#/");
    String pgTitle = driver.getTitle();
        System.out.println("Home Page Title:"+ pgTitle);
    }

    public void pgNavigation() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='menuUser']")).click();
        Thread.sleep(5000);
        String lgnpgTitle = driver.getTitle();
        System.out.println(lgnpgTitle);

    }

    public void createAccount() throws InterruptedException {

    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("test@gmail.com");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("#sign_in_btnundefined")).click();
    Thread.sleep(3000);
    String crtAccErrMsg = driver.findElement(By.cssSelector("#signInResultMessage")).getText();
     Thread.sleep(3000);
        System.out.println("ERROR:"+crtAccErrMsg);

    }

    public void closeBrowser(){
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        AdvantageOnline ao = new AdvantageOnline();
        ao.launchBrowser();
        ao.pgNavigation();
        ao.createAccount();
        ao.closeBrowser();

    }
}
