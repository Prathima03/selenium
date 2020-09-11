package com.bitsai.testcases;

import com.bitsai.pageObjects.HomePage;
import com.bitsai.pageObjects.LoginPage;
import com.bitsai.pageObjects.PlaceOrder;
import com.bitsai.pageObjects.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartcheckOutTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    PlaceOrder placeOrder;

    public CartcheckOutTest(){
        super();
    }

  @BeforeTest
  public void setUp(){
        initialize();
        loginPage = new LoginPage(driverTB);
        homePage = new HomePage(driverTB);
       // placeOrder = new PlaceOrder(driverTB);
  }

  @Test
    public void setPlaceOrder(){
        String tit = loginPage.validateLoginPage();
      Assert.assertEquals(tit,"My Store");
      loginPage.login("testing3.automationsel@gmail.com","colddrink");
      loginPage.clickSubmit();
      homePage.accountPage();
      homePage.goMainPage();
      homePage.tShirt();
      loginPage.enlargeImage();
      loginPage.addCartFunc();
      loginPage.prcdChkoutFunc();
      loginPage.prcdChkoutFunc2();
      loginPage.prcdChkoutFunc3();
      loginPage.prcdChkoutFunc4();
      loginPage.payment();
      loginPage.clickConfirm();
      loginPage.singOut();

  }

  @AfterTest
    public void aftrTst(){
        driverTB.quit();
  }


}
