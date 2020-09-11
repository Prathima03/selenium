package com.bitsai.testcases;

import com.bitsai.pageObjects.CreateAccount;
import com.bitsai.pageObjects.HomePage;
import com.bitsai.pageObjects.LoginPage;
import com.bitsai.pageObjects.TestBase;
import com.bitsai.utilities.TestUtilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.*;

public class CreateAccountTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    CreateAccount createAccount;
    String sheetName = "customerdata";
    public CreateAccountTest(){
        super();
    }

    @BeforeTest
    public void setUp(){
        initialize();
        loginPage = new LoginPage(driverTB);
        homePage = new HomePage(driverTB);
        createAccount = new CreateAccount(driverTB);
            }

    @DataProvider
    public Object[][] getCustomerData() {
        Object data[][] = TestUtilities.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getCustomerData")
    public void createAccount(String CustomerFirstName,String CustomerLastName,String CustomerEmail,
                              String Password,String DOB_days,String DOB_month,String DOB_Yrs,String CFname,String CLname,
                              String Company,String Address,String City,String State,String PostalCode,String Country,
                              String Comments,String HomePhone,String MobileNumber,String Alias) {
        loginPage.navgsignin();
       // loginPage.setTxtEmailID(property.getProperty("emailId"));
        loginPage.setCrtEmail(property.getProperty("emailId"));
        loginPage.clickCreate();

        createAccount.fillCustomerForm(CustomerFirstName,CustomerLastName,CustomerEmail,Password,DOB_days,DOB_month,
                                       DOB_Yrs,CFname,CLname,Company,Address,City,State,PostalCode,Country,Comments,HomePhone,MobileNumber,Alias);
        createAccount.clickregisterBtn();
       }

      @AfterTest
    public void tearDown(){
        driverTB.quit();
    }

}
