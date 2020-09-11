package com.onlineshopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WaitingMechanism {
    WebDriver driver;
    String wDriver = "webdriver.gecko.driver";
    String sDriverLoc = "C:/Users/Ravi/Drivers/Firefox/geckodriver.exe";
    String appUrl = "http://automationpractice.com/index.php";


    public void launching(){

        System.setProperty(wDriver,sDriverLoc);
        driver = new FirefoxDriver();
        driver.get(appUrl);
        String pgTitle = driver.getTitle();
        System.out.println("Home Page Title :"+pgTitle);

    }

    public void Navigation(){
        driver.findElement(By.partialLinkText("Sign")).click();
        String lgnpgTitle = driver.getTitle();
        System.out.println("Login Page Title :"+lgnpgTitle);

    }

    public void signingIn() throws InterruptedException {
        driver.findElement(By.cssSelector("#email_create")).sendKeys("testing3.automationsel.@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);

        // String crtAccErrMsg = driver.findElement(By.xpath("//div[@id='create_account_error']")).getText();
        //Thread.sleep(3000);
        //System.out.println("Create Account Error Msg :"+crtAccErrMsg);

        String crtAccPg = driver.findElement(By.className("page-subheading")).getText();
        //crtAccPg = String
        Thread.sleep(2000);
        System.out.println(crtAccPg);
        Thread.sleep(2000);

        if(crtAccPg.equals("YOUR PERSONAL INFORMATION")){
            Thread.sleep(2000);

            driver.findElement(By.id("id_gender2")).click();
            driver.findElement(By.id("customer_firstname")).sendKeys("coco");
            driver.findElement(By.id("customer_lastname")).sendKeys("cola");
            String chckMailId = driver.findElement(By.id("email")).getText();

            if(chckMailId.isEmpty()){
                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys("testing3.automationsel@gmail.com");
            }

            driver.findElement(By.id("passwd")).sendKeys("colddrink");
            Thread.sleep(2000);

            Select bDay = new Select(driver.findElement(By.id("days")));
            bDay.selectByValue("10");
            Thread.sleep(2000);

            Select bMonth = new Select(driver.findElement(By.id("months")));
            bMonth.selectByIndex(1);
            Thread.sleep(2000);

            Select bYear = new Select(driver.findElement(By.id("years")));
            bYear.selectByValue("1980");
            Thread.sleep(2000);

            driver.findElement(By.id("uniform-optin")).click();
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys("coco");
            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys("cola");
            driver.findElement(By.id("company")).sendKeys("Bitsai");
            driver.findElement(By.id("address1")).sendKeys("abc");
            driver.findElement(By.id("city")).sendKeys("Oshawa");

            Select state = new Select(driver.findElement(By.id("id_state")));
            state.selectByIndex(18);
            Thread.sleep(2000);

            driver.findElement(By.id("postcode")).sendKeys("40203");
            driver.findElement(By.id("id_country")).sendKeys("United States");
            driver.findElement(By.id("phone")).sendKeys("1234567890");
            driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
            driver.findElement(By.id("alias")).sendKeys("abc def ghi");
        }
    }



    public void sbtAccnt(){
        driver.findElement(By.id("submitAccount")).click();
    }

    public void msgVerify(){
        String msgVerify = driver.findElement(By.className("info-account")).getText();
        System.out.println(msgVerify);
    }

    public void signOut(){
        driver.findElement(By.className("logout")).click();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitingMechanism we = new WaitingMechanism();
        we.launching();
        we.Navigation();
        we.signingIn();
        we.sbtAccnt();
        we.msgVerify();
        we.signOut();
        we.closeBrowser();
    }



}
