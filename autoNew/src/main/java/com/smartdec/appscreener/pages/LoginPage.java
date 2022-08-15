package com.smartdec.appscreener.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.smartdec.appscreener.utils.ConstantStorage.*;
import static com.smartdec.appscreener.utils.XpathStorage.*;

public class LoginPage extends BasePage {

    protected SelenideElement enter = $x("//div[@class='mat-tab-label-content' and contains(text(),'Вход')]");

    protected ElementsCollection auth = $$x("//input[contains(@id,'auth')]");
    protected SelenideElement btnEnter = $("#login-auth_login_button");



    @Step("Дожидаюсь прогрузки Login Page")
    public LoginPage checkLogo() {
        System.out.println(" Дожидаюсь прогрузки Login Page");
        $x(APPSCREENER_LOGO_LOGIN_PAGE).shouldBe(visible);
        return this;
    }

    @Step("Проверяю наличие логин формы на странице")
    public LoginPage checkLoginFormInPage() {
        SelenideElement loginForm = $x(APPSCREENER_LOGIN_FORM_IN_LOGIN_PAGE);
        System.out.println("Проверка на видимость логин формы на странице");
        loginForm.shouldBe(visible);
        System.out.println("Проверка корректной url - login url - на текущей странице");

        webdriver().shouldHave(urlContaining("https://appscreener-dev.ast.rt-solar.ru/login"));
        return this;
    }

    @Step("Ввожу тестовые данные Admin юзера")
    public LoginPage setValueAdminUser() {
        System.out.println("Вводим тестовые данные Admin юзера");
        sleep(10000);
        /*$x(APPSCREENER_LOGIN_FORM_IN_LOGIN_PAGE).shouldBe(visible);*/
        $x(APPSCREENER_LOGIN_INPUT_IN_LOGIN_PAGE).shouldBe(visible).setValue(ADMIN_USER_LOGIN);
        $x(APPSCREENER_PASSWORD_INPUT_IN_LOGIN_PAGE).shouldBe(visible).setValue(ADMIN_USER_PASS);
        return this;
    }

    @Step("Ввожу тестовые данные Default юзера")
    public LoginPage setValueDefaultUser() {
        System.out.println("Вводим тестовые данные Default юзера");
        $x(APPSCREENER_LOGIN_FORM_IN_LOGIN_PAGE).shouldBe(visible);
        $x(APPSCREENER_LOGIN_INPUT_IN_LOGIN_PAGE).shouldBe(visible).setValue(DEFAULT_USER_LOGIN);
        $x(APPSCREENER_PASSWORD_INPUT_IN_LOGIN_PAGE).shouldBe(visible).setValue(DEFAULT_USER_PASS);
        return this;
    }

    @Step("Жму на кнопку логина")
    public LoginPage clickLoginButton() {
        SelenideElement incorrectAlert = $x(APPSCREENER_INCORRECT_LOGIN_ALERT_IN_LOGIN_PAGE);
        System.out.println("Нажимаю на Login Button");
        $x(APPSCREENER_LOGIN_BUTTON_IN_LOGIN_PAGE).shouldBe(visible).scrollTo().click();

        if (!incorrectAlert.isDisplayed()) {
            System.out.println("Пользователь залогинен.");
        } else {
            System.out.println("Неверный логин или пароль.");
        }
        return this;
    }

    @Step("Жму на кнопку забыли пароль")
    public LoginPage clickForgotPasswordButton() {
        $x(APPSCREENER_FORGOT_PASSWORD_BUTTON_IN_LOGIN_PAGE).shouldBe(visible).click();
        $x(APPSCREENER_FEEDBACK_FORM_IN_LOGIN_PAGE).shouldBe(visible);
        return this;
    }

    @Step("Принимаю лицензионный договор")
    public LoginPage confirmLicenseDocument() {
        SelenideElement LicenseDocument = $x(APPSCREENER_LICENSE_DOCUMENT);
        sleep(1000);
        if (LicenseDocument.isDisplayed()) {
            LicenseDocument.shouldBe(visible);
            $x(APPSCREENER_BUTTON_TO_CONFIRM_LICENSE_DOCUMENT).scrollTo().shouldBe(visible).click();
        } else {
            System.out.println("LICENSE DOCUMENT MISSING" + "\n");
        }

        return this;
    }

    @Step("Провожу ознакомление с инструкцией")
    public LoginPage confirmInstructionDocument() {
        SelenideElement Instruction = $x(APPSCREENER_INFORMATION_TUTORIAL);
        SelenideElement AccountStatusForm = $x(APPSCREENER_ACCOUNT_STATUS_FORM);
        sleep(1000);
        if (Instruction.isDisplayed()) {
            Instruction.shouldBe(visible);
            $x(APPSCREENER_BUTTON_TO_CONFIRM_INFORMATION_TUTORIAL_NEXT).scrollTo().shouldBe(visible).click();
            $x(APPSCREENER_BUTTON_TO_CONFIRM_INFORMATION_TUTORIAL_FINISH).scrollTo().shouldBe(visible).click();

        } else {
            System.out.println("LICENSE DOCUMENT MISSING" + "\n");
        }
        sleep(1500);
        if (AccountStatusForm.isDisplayed()) {
            $x(APPSCREENER_ACCOUNT_STATUS_FORM_BUTTON_CONFIRM).scrollTo().shouldBe(visible).click();
        } else {
            System.out.println("Форма состояния учетной записи отсутствует");
        }

        return this;
    }

    @Step("Логин админ юзера")
    public LoginPage loginAdminUserMethod() {
        checkLogo();
        setValueAdminUser();
        clickLoginButton();
        confirmLicenseDocument();
        confirmInstructionDocument();
        return this;
    }
 @Step("Confirm documents and start")
    public LoginPage getStartedAfterLogin() {
        clickLoginButton();
        confirmLicenseDocument();
        confirmInstructionDocument();
        return this;
    }

    @Step("Логин админ юзера")
    public LoginPage loginDefaultUserMethod() {
        checkLogo();
        setValueDefaultUser();
        clickLoginButton();
        confirmLicenseDocument();
        confirmInstructionDocument();
        return this;
    }

    /**
     * Метод заполняет поля страницы авторизации
     *
     * @param - наименование заполняемого поля
     * @param value - значение, которое будет использовано при заполнении поля
     * @return -возвращаемы параметры
     */

    @Step("Заполняем поля Логин/Пароль")
    public LoginPage fillField(String nameField, String value) {
        for (SelenideElement element : auth) {
            if (element.attr("data-placeholder").equals(nameField)) {
                element.shouldBe(Condition.visible).setValue(value);
                return  this;
            }
        }
        Assertions.fail("Данного элемента нет на странице");
        return this;
    }


    public LoginPage fillFieldSelenide(String id, String value) {
        $("#" + id).setValue(value);
        return this;
    }

    @Step("Клик на кнопку \"войти\"")
    public HomePage clickEnter() {
        btnEnter.click();
        return new HomePage();
    }




}
