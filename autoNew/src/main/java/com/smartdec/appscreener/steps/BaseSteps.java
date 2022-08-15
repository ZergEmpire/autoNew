package com.smartdec.appscreener.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.smartdec.appscreener.managers.PageManager;
import com.smartdec.appscreener.pages.BasePage;
import com.smartdec.appscreener.pages.HomePage;
import com.smartdec.appscreener.pages.LoginPage;
import com.smartdec.appscreener.pages.ProfilePage;
import com.smartdec.appscreener.pages.administration.users.CreateUserPage;
import com.smartdec.appscreener.pages.administration.users.utils.Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mn.Харин;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {
    PageManager pageManager = PageManager.getPageManager();

    @Given("open one appScreener url")
    public void openOneUrl(){
        pageManager.getPage(BasePage.class).openURL();
        sleep(1000);
    }
    @Given("open two appScreener urls")
    public void openTwoUrls(){
        pageManager.getPage(BasePage.class).OpenTwoURLsAndSwitchToFirstUrl();
        sleep(1000);
    }
    @And("switch to second url")
    public void switchToSecondUrl(){
        pageManager.getPage(BasePage.class).switchToSecondOpenedUrl();
    }
    @And("switch to first url")
    public void switchToFirstUrl(){
        pageManager.getPage(BasePage.class).switchToFirstOpenedUrl();
    }
    @And("webDriver close")
    public void closeMethod(){
        sleep(2000);
        closeWebDriver();
        sleep(2000);
    }
    @And("refresh page")
    public void refreshPage(){
        pageManager.getPage(BasePage.class).refreshPage();
    }

    @Then("wait scan finish")
    public void waitScanFinish() {
        pageManager.getPage(BasePage.class).WaitScanFinish();
    }
    @Then("check input for projects URL's")
    public void checkInputForProjectsURLS() {
        pageManager.getPage(HomePage.class).checkInputForProjectUrls();

    }

    @And("login in default user account")
    public void loginInDefaultUserAccount(){
        pageManager.getPage(LoginPage.class).loginDefaultUserMethod();
    }
    @And("login in admin user account")
    public void loginInAdminUserAccount(){
        pageManager.getPage(LoginPage.class).loginAdminUserMethod();
    }

    @Given("open appScreener url and login in admin user")
    public void openAppScreenerUrlAndLoginInAdminUser() {
        openOneUrl();
        checkConditionPage();
       /* loginInAdminUserAccount();
        checkInputForProjectsURLS();*/
    }

    private void checkConditionPage() {
        SelenideElement loginContainer = $x("//div[@class = \"login-container\"]");
        if (loginContainer.isDisplayed()){
            loginInAdminUserAccount();
            checkInputForProjectsURLS();
        }
        else{
            System.out.println("Login container not displayed.");
        }
    }
}
