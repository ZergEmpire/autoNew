package com.smartdec.appscreener.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.smartdec.appscreener.managers.DriverManager;
import com.smartdec.appscreener.managers.PageManager;
import com.smartdec.appscreener.managers.TestPropManager;
import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.reopenBrowserOnFail;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.fail;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();
//    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));
//    private final TestPropManager props = TestPropManager.getTestPropManager();
//    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

//    public BasePage() {
//        PageFactory.initElements(driverManager.getDriver(), this);
//    }




    // Метод для открытия двух вкладок appScreener.
    @Step("Открываю appScreener URL")
    public BasePage openURL(){
        System.out.println("Open URL appScreener");
        sleep(1000);
        open("https://appscreener-dev.ast.rt-solar.ru/");
        sleep(4000);
       return this;
    }
    //Переключиться на первую вкладку
    @Step("Переход на первую страницу")
    public BasePage OpenTwoURLsAndSwitchToFirstUrl(){

        open("https://appscreener-dev.ast.rt-solar.ru/");
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        switchTo().window(1);
        open("https://appscreener-dev.ast.rt-solar.ru/");
        switchTo().window(0);
        return this;
    }
    //Переключиться на вторую вкладку
    @Step("Переход на вторую открытую вкладку")
    public BasePage switchToSecondOpenedUrl(){
        switchTo().window(1);
        return this;
    }
    @Step ("Переход на первую открытую вкладку")
    public BasePage switchToFirstOpenedUrl() {
        switchTo().window(0);
        return this;
    }


public BasePage longWaitElement(SelenideElement element){
        element.shouldHave(exist);
        return this;
}


    //заполнение inputа с проверкой
    protected void fillInputField(SelenideElement field, String value) {
        field.shouldBe(visible).setValue(value);
    }
//
    public BasePage refreshPage(){
        refresh();
        sleep(2000);
        return this;
    }
    public BasePage WaitScanFinish(){
        sleep(5000);
        SelenideElement element = $x("//div[contains(@class, \"swiper-slide-active\")]//p[(@class = \"status\") and (contains(text(), \"Completed\")) or(contains(text(), \"Завершено\"))  ]");
        SelenideElement element2 = $x("//div[contains(@class, \"swiper-slide-active\")]//i[contains(@class, \"icon-error\")]");
        while (!element.isDisplayed()){
            System.out.println("Запуск цикла" + "\n");
            if (element.isDisplayed()){
                element.shouldBe(visible);
                System.out.println("element visible" + "\n");
                break;
            }
            else if (element2.isDisplayed()){
                fail("ошибка сканирования");
            }
            else {
                sleep(10000);
            }
        }
        return this;
    }

    public BasePage clickMainPage() {
        $x("//div[@class = \"logo\"]").click();
        return this;
    }


    //явное ожидание того, что элемент станет видимым
//    protected WebElement waitUtilElementToBeVisible(WebElement element) {
//        try {
//            return wait.until(ExpectedConditions.visibilityOf(element));
//        } catch (TimeoutException e) {
//            Assertions.fail("Элемент не виден");
//        }
//        return element;
//    }

    //явное ожидание того, что элемент станет кликабельным
//    protected WebElement waitUtilElementToBeClickable(WebElement element) {
//        try {
//            return wait.until(ExpectedConditions.elementToBeClickable(element));
//        } catch (TimeoutException e) {
//            Assertions.fail("Элемент не кликабелен");
//        }
//        return element;
//    }

    //скрол до элемента
//    protected WebElement scrollToElementJs(WebElement element) {
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        return element;
//    }

//    заполнение inputа с проверкой
//    protected void fillInputField(WebElement field, String value) {
//        waitUtilElementToBeClickable(field).click();
//        field.sendKeys(value);
//        try {
//            wait.until(ExpectedConditions.attributeContains(field, "value", value));
//        } catch (TimeoutException e) {
//            Assertions.fail("Поле было заполнено некорректно");
//        }
//    }



}