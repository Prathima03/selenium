package com.bitsai.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
    WebDriver lDriver;
    public HomePage(WebDriver rDriver){
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    //MyAccount pagetitle
    @FindBy(className = "navigation_page")
    WebElement showtxtaccpage;
    public HomePage()
    {
    }
    public String accountPage(){
       return showtxtaccpage.getText();
    }

    //MyAccount HomeButton
    @FindBy(xpath = "//i[@class='icon-home']")
    WebElement clckHomeBtn;
    public void goMainPage(){
        clckHomeBtn.click();
    }

    //subcategory T-Shirts
    @FindBy(xpath = "//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1] ")
    WebElement tshrtBtn;
    public void tShirt(){
        tshrtBtn.click();
    }

    //order history and details
    @FindBy(className = "icon-list-ol")
    WebElement ordHistoryBtn;

    @FindBy(className = "icon-heart")//wishlist button
    WebElement wishListBtn;

    @FindBy(className = "icon-ban-circle")//creditslips button
    WebElement crdtSlipsBtn;

    @FindBy(className = "icon-building")//My Address Button
    WebElement myAddrbtn;

    @FindBy(className = "icon-user")//my personal information
    WebElement myPrsnInfoBtn;

    @FindBy(linkText = "Sign out")
    WebElement lnkSingout;

    public boolean validateHomePage(){
        return lnkSingout.isDisplayed();
    }
}
