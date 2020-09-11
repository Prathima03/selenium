package com.bitsai.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrder extends TestBase {
    WebDriver ordDriver;
    LoginPage loginPage;
    HomePage homePage;


    public void PlaceOrder(WebDriver ordDriver){
        ordDriver = ordDriver;
        PageFactory.initElements(ordDriver,this);
    }

    public void orderAndShipping(){
        String tit = loginPage.validateLoginPage();
        Assert.assertEquals(tit,"My Store");
        loginPage.login("testing3.automationsel@gmail.com","colddrink");
        loginPage.clickSubmit();
        homePage.goMainPage();
        homePage.tShirt();
        loginPage.addCartFunc();
        loginPage.prcdChkoutFunc();
        loginPage.prcdChkoutFunc2();
        loginPage.prcdChkoutFunc3();
        loginPage.prcdChkoutFunc4();
        loginPage.bankdetails.click();
        loginPage.cnfrmOrder.click();
        loginPage.signOtBtn.click();
    }
}
