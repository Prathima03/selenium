package com.bitsai.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver lDriver;

    public LoginPage(WebDriver rdriver) {
        lDriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //homepage signin button
    @FindBy(partialLinkText = "Sign")
    WebElement btnHmSignin;
    public void navgsignin() {
        btnHmSignin.click();
    }

    //login account emailId textbox
    @FindBy(id ="email")
    @CacheLookup
    WebElement txtEmailID;
    public void setTxtEmailID(String emailID) {
        txtEmailID.clear();
        txtEmailID.sendKeys(emailID);
    }

    @FindBy(id ="passwd")
    WebElement txtPswd;
    public void setTxtPwd(String txtPwd) {
        txtPswd.clear();
        txtPswd.sendKeys(txtPwd);
    }

    @FindBy(name ="SubmitLogin")
    @CacheLookup
    WebElement btnSignin;
    public void clickSubmit()
    {
        btnSignin.click();
    }

    @FindBy(id = "email_create")
    WebElement crtEmail;
    public void setCrtEmail(String crtemail){
        crtEmail.clear();
        crtEmail.sendKeys(crtemail);
    }

    //create account button
    @FindBy(name = "SubmitCreate")
    @CacheLookup
    WebElement btnCrtAcc;
    public void clickCreate(){
        btnCrtAcc.click();
    }

    //Error msg invalid emailid

    @FindBy(id = "Create Account Error")
    WebElement errMsg;
    public String invalidLogin(){
        return errMsg.getText();
    }

    //logoCheck
    @FindBy(className = "logo img-responsive")
    WebElement logoDisplay;
    public boolean chckLogo(){
        return logoDisplay.isDisplayed();
    }

    public String validateLoginPage(){
        System.out.println(lDriver.getTitle());
        return lDriver.getTitle();
            }

     public HomePage login(String emailId,String pwd){
        txtEmailID.sendKeys(emailId);
        txtPswd.sendKeys(pwd);
        clickSubmit();
        chckLogo();

        return new HomePage();
    }


    //****add to cart

  @FindBy(xpath = "//a[@class='product_img_link']//img[@class='replace-2x img-responsive'] ")//click on tshirt img
    WebElement tshirtimage;
    public void enlargeImage() {
        tshirtimage.click();
    }

    @FindBy(id = "add_to_cart")// tshirt add to cart button
    WebElement addCartBtn;
    public void addCartFunc() {
        addCartBtn.click();
    }

    @FindBy(className = "btn btn-default button button-medium")// proceed to checkout button
    WebElement prcdChkoutBtn;
    public void prcdChkoutFunc(){
        prcdChkoutBtn.click();
    }

    //final proceed to checkout button
    @FindBy(xpath = "\t//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')] ")
    WebElement prcdChkoutBtn2;
    public void prcdChkoutFunc2(){
        prcdChkoutBtn2.click();
    }

    @FindBy(className = "button btn btn-default button-medium")//Address tab proceed to checkout button
    WebElement prcdChkoutBtn3;
    public void prcdChkoutFunc3(){
        prcdChkoutBtn3.click();
    }

   @FindBy(id = "cgv")// terms & conditions checkbox
    WebElement agreechkBox;

    @FindBy(className = "button btn btn-default standard-checkout button-medium")//shipping tab proceed to checkout button
    WebElement prcdChkoutBtn4;
    public void prcdChkoutFunc4(){
        agreechkBox.click();
        prcdChkoutBtn4.click();
    }

    @FindBy(xpath = "//a[@class='bankwire']")//payment tab bankwire option
    WebElement bankdetails;
    public void payment(){
        bankdetails.click();
    }

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement cnfrmOrder;
    public void clickConfirm(){
        cnfrmOrder.click();
     String co = cnfrmOrder.getText();
    }

    @FindBy(className = "logout")
    WebElement signOtBtn;
    public void singOut(){
        signOtBtn.click();
    }

}


