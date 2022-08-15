package com.smartdec.appscreener.pages.administration.users;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.smartdec.appscreener.pages.BasePage;
import com.smartdec.appscreener.pages.administration.users.utils.User;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;

public class CreateUserPage extends BasePage {


    protected SelenideElement userLoginField = $("#user_login");

    protected SelenideElement userNewPasswordField = $("#user_new_password");

    protected SelenideElement userConfirmPassword = $("#user_confirm_password");

    protected SelenideElement userFullNameField = $("#user_full_name");

    protected SelenideElement userEmailField = $("#user_email");

    protected SelenideElement userOrganizationField = $("#user_organization");

    protected SelenideElement userPositionField = $("#user_position");


    protected SelenideElement adminRootRadioBtn = $x("//*[@id='user_admin_roles']//span[@class='mat-radio-label-content']");


    protected SelenideElement defaultRootRadioBtn = $x("//*[@id='user_admin_roles']//span[@class='mat-ripple mat-radio-ripple mat-focus-indicator']");


    protected SelenideElement saveBtn = $("#save_button");

    protected SelenideElement listOfUser = $("#users");

    protected SelenideElement userAlreadyCreateIcon = $x("//*[@class='icon-error icon-error-absolute']");


    /**
     * Метод используется для заполнения данных пользователя при создании ного пользователя-администратора
     *
     * @return - злемент типа Pageobject
     */
    @Step("Заполнение данных пользователя")
    public CreateUserPage fillUsersFields(User user) {
        fillInputField(userLoginField, user.user_login);
        fillInputField(userNewPasswordField, user.user_new_password);
        fillInputField(userConfirmPassword, user.user_confirm_password);
        fillInputField(userFullNameField, user.user_full_name);
        fillInputField(userEmailField, user.userEmail);
        fillInputField(userPositionField, user.userPosition);
        if (user.adminRoot == true) {
            adminRootRadioBtn.click();
        } else if (!user.adminRoot == false) {
            defaultRootRadioBtn.click();

        }

        return this;
    }


    /**
     * Нажимает кнопку сохранить и проверяет наличие иконки об ошибке
     * Может выбросить искоючение NoSuchElementException
     *
     * @return - возвращает элемент типа PageObject
     */

//TODO - заменить Thread.sleep потока на ожидание
    //TODO - выбрасывает исключение NoSuchElementException дописать обработку
    @Step("Нажать кнопку \"Сохранить\"")
    public ListOfUsers saveBtnClick() {
        saveBtn.scrollTo().click();
        sleep(2000);
            if (userAlreadyCreateIcon.exists()) {
                userAlreadyCreateIcon.scrollTo();
                sleep(2000);
                Assert.assertFalse("Данный пользователь существует", !userAlreadyCreateIcon.getSize().equals(null));
            }

                return new ListOfUsers();
    }



}
