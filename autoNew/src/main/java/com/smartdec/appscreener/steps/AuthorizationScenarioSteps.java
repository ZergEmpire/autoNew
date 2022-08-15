package com.smartdec.appscreener.steps;
import com.codeborne.selenide.Condition;
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

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
public class AuthorizationScenarioSteps {
    PageManager pageManager = PageManager.getPageManager();

    @And("log out from user")
    public void logOutMethod(){
        pageManager.getPage(ProfilePage.class).logOutFromUserProfile();
    }

    @When("click to icon personal account")
    public void clickToIconPersonalAccount(){
        pageManager.getPage(HomePage.class).PersonalAccountClick();
    }
    @When("the user is on the second open page, start logging in an Admin user")
    public void loginAdminUser(){
        pageManager.getPage(LoginPage.class).loginAdminUserMethod();
    }
    @When("the user is on the second open page, start logging in an Default user")
    public void loginDefaultUser(){
        pageManager.getPage(LoginPage.class).loginDefaultUserMethod();
    }
    @When("user log out - check login form is displayed")
    public void checkDisplayedLoginFormAsterLogOut(){
        pageManager.getPage(LoginPage.class).checkLoginFormInPage();
    }
    @Then("check Default user after logged in")
    public void checkDefaultUserAfterLoggedIn(){
        pageManager.getPage(ProfilePage.class).CheckDefaultUser();
    }
    @Then("check admin user is logged in")
    public void checkAdminUserAfterLoggedIn(){
        pageManager.getPage(ProfilePage.class).CheckAdminUser();
    }



}
