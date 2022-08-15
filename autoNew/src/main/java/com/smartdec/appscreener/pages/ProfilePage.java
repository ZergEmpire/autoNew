package com.smartdec.appscreener.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.hu.De;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.smartdec.appscreener.utils.ConstantStorage.*;
import static com.smartdec.appscreener.utils.XpathStorage.*;

import java.awt.color.ProfileDataException;
import java.util.List;
public class ProfilePage extends BasePage{

    @Step("Проверяю тестового Default юзера")
    public ProfilePage CheckDefaultUser(){
        SelenideElement DefaultUser = $x(APPSCREENER_PROFILE_LOGIN_USER_DEFAULT_USER);
        SelenideElement AdminUser = $x(APPSCREENER_PROFILE_LOGIN_USER_ADMIN_USER);
        System.out.println("Проверяю корректность URL");
        webdriver().shouldHave(url("https://appscreener-dev.ast.rt-solar.ru/account/profile/general"));
        if (DefaultUser.isDisplayed()){
            AdminUser.shouldNotBe(Condition.visible);
            System.out.println(DEFAULT_USER_LOGIN + " displayed");
        }
        else {
            System.out.println("Пользователь не совпадает с DefaultUser ");
        }
        return this;
    }
    @Step("Проверяю тестового Admin юзера")
    public ProfilePage CheckAdminUser(){
        sleep(2000);
         SelenideElement DefaultUser = $x(APPSCREENER_PROFILE_LOGIN_USER_DEFAULT_USER);
         SelenideElement AdminUser = $x(APPSCREENER_PROFILE_LOGIN_USER_ADMIN_USER);
         System.out.println("Проверяю корректность URL");
         webdriver().shouldHave(url("https://appscreener-dev.ast.rt-solar.ru/account/profile/general"));
         if (AdminUser.isDisplayed()){
             DefaultUser.shouldNotBe(Condition.visible);
             System.out.println(ADMIN_USER_LOGIN + " displayed");
         }
         else {
             System.out.println("Пользователь не совпадает с AdminUser ");
         }
         return this;
    }

    @Step("Logout из учётной записи пользователя")
    public ProfilePage logOutFromUserProfile(){
        SelenideElement LogOutButton = $x(APPSCREENER_PROFILE_LOGOUT_BUTTON);
        SelenideElement Logo = $x(APPSCREENER_LOGO_LOGIN_PAGE);
        SelenideElement LogOutButtonUserMenu = $x(APPSCREENER_PROFILE_USERNAME_MENU_LOGOUT_BUTTON);
        if (LogOutButton.exists()) {
            actions().moveToElement(Logo).build().perform();
            System.out.println("Отвожу курсор к лого, с целью убрать user menu");
            actions().moveToElement(LogOutButton).click().build().perform();

        }
        else if (LogOutButtonUserMenu.isDisplayed()){
            System.out.println("Отвожу курсор к лого, с целью убрать user menu");
            actions().moveToElement(Logo).build().perform();
            actions().moveToElement(LogOutButtonUserMenu).click().build().perform();

        }
        else {
            System.out.println("Не могу прокликать кнопку logOut");
        }

        return this;
    }



}
