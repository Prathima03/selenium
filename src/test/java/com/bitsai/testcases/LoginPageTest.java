package com.bitsai.testcases;

import com.bitsai.pageObjects.HomePage;
import com.bitsai.pageObjects.LoginPage;
import com.bitsai.pageObjects.TestBase;
import com.google.common.annotations.VisibleForTesting;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){
    initialize();
    loginPage = new LoginPage(driverTB);
    homePage = new HomePage(driverTB);
    }
   @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPage();
      Assert.assertEquals(title,"My Store");
          }

    @Test(priority=2)
    public void logoTest(){
        boolean logo= loginPage.chckLogo();
        Assert.assertTrue(logo);
    }

    @Test(priority=3)
    public void navPageSignin(){
        loginPage.navgsignin();
    }

    @Test(priority=4)
    public void logintest(){
    navPageSignin();
    loginPage.setTxtEmailID(property.getProperty("emailId"));
    loginPage.setTxtPwd(property.getProperty("pwd"));
    loginPage.clickSubmit();
    //homePage = loginPage.login(property.getProperty("emailId"),property.getProperty("pwd"));
    boolean lnkSignout = homePage.validateHomePage();
    Assert.assertTrue(lnkSignout);
    }

    @AfterMethod
    public void tearDown(){
        driverTB.quit();
    }
}
