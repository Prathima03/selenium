package com.bitsai.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
    WebDriver lDriver;

    public CreateAccount(WebDriver rDriver){
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

  /*  @FindBy(id = "SubmitCreate")
    WebElement txtEmailId;

    public void setTxtlEmaiId(String EmaiId) {
        txtEmailId.click();
    }*/

    @FindBy(id = "id_gender1")
    WebElement rdButnMr;

    @FindBy(id = "id_gender2")
    WebElement rdButnMrs;

    @FindBy(id = "customer_firstname")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement Days;
    public void selelectDay(String valDay) {
        Days.sendKeys(valDay);
       // Select statusDropdown = new Select(Days);
       // statusDropdown.selectByValue(valDay);
    }

    @FindBy(id = "months")
    WebElement Months;
    public void selectMonth(String valMonth)
    {
        Months.sendKeys(valMonth);
     // Select statusDropdown = new Select(Months);
    //  statusDropdown.selectByValue(valMonth);
    }

    @FindBy(id = "years")
    WebElement Years;
    public void selectYear(String valYear){
        Select statusDropdown = new Select(Years);
        statusDropdown.selectByValue(valYear);
    }

    @FindBy(id = "optin")
    WebElement chkBox;

    @FindBy(id = "firstname")
    WebElement custFirstName;

    @FindBy(id = "lastname")
    WebElement custLastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;
    public void selectState(String valState){
       // state.clear();
       if( state.isDisplayed()) {
           state.sendKeys(valState);
       }
     //   Select statusDropdown = new Select(state);
     //   statusDropdown.selectByValue(valState);
    }

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement country;
    public void selectCountry(String valCntry){
       Select statusDropdown = new Select(country);
       statusDropdown.selectByValue(valCntry);
    }

    @FindBy(id = "other")
    WebElement otherinfo;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "phone_mobile")
    WebElement mobile;

    @FindBy(id = "alias")
    WebElement altAddress;

    @FindBy(id = "submitAccount")
    WebElement registerBtn;
    public void clickregisterBtn() {
        registerBtn.click();
    }

    public  void fillCustomerForm(String fName, String lName, String cusEmail, String pwd,
                                  String days, String mnths, String yrs, String cFname,
                                  String cLname,String compny, String addr1,String cty,String stte,
                                  String pcode,String cntry,String comments,String phn,String mob,String altaddr)

    {
        rdButnMr.click();
        txtFirstName.clear();
        txtFirstName.sendKeys(fName);
        txtLastName.clear();
        txtLastName.sendKeys(lName);
        email.clear();
        email.sendKeys(cusEmail);
        password.sendKeys(pwd);

      // selelectDay(days);
        Days.sendKeys(days);
        Months.sendKeys(mnths);
        //selectYear(yrs);
        //selectMonth(mnths);
        Years.sendKeys(yrs);
       // chkBox.sendKeys(chkbox);
        custFirstName.clear();
        custFirstName.sendKeys(cFname);
        custLastName.clear();
        custLastName.sendKeys(cLname);
        company.sendKeys(compny);
        address1.sendKeys(addr1);

       // address2.sendKeys(addr2);

        city.sendKeys(cty);
        state.sendKeys(stte);
        postcode.sendKeys(pcode);
        country.sendKeys(cntry);
        otherinfo.sendKeys(comments);
        phone.sendKeys(phn);
        mobile.sendKeys(mob);
        altAddress.sendKeys(altaddr);
        }

    public void setTxtFirstName(String custFirstname) {
        txtFirstName.sendKeys();
    }
    public void setEmail(String emailID){
        email.clear();
        email.sendKeys(emailID);
    }
    public void setPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }

   }
