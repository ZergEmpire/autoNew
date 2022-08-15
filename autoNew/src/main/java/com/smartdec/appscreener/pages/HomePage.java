package com.smartdec.appscreener.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.webdriver.Url;
import com.smartdec.appscreener.pages.administration.users.CreateUserPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.smartdec.appscreener.utils.XpathStorage.*;
import static com.smartdec.appscreener.utils.ConstantStorage.*;


public class HomePage extends BasePage {

    private SelenideElement enter = $x("//div[@class='mat-tab-label-content' and contains(text(),'????')]");

    private ElementsCollection auth = $$x("//input[contains(@id,'auth')]");

    private SelenideElement btnEnter = $x( "login-auth_login_button");

    protected SelenideElement acceptBtn = $("#eula-appscreener-dialog_accept_eula");

    protected SelenideElement nextBtn = $("#information_tutorial_next_tutorial");

    protected SelenideElement getStartedBtn = $("#information_tutorial_get_started_tutorial");

    protected SelenideElement adminBtn = $("#main_administration_tab");

    protected  SelenideElement createNewUserBtn = $("#users-table_create_user");

    SelenideElement PopupAfterStartAnalyse = $x(APPSCREENER_POPUP_AFTER_START_ANALYSE);
    public HomePage fillField(String nameField, String value) {
        for (SelenideElement element : auth) {

            if (element.attr("data-placeholder").equals(nameField)) {
                element.shouldBe(visible).setValue(value);
                return  this;
            }
        }
        Assertions.fail("Данного элемента нет на странице");
        return this;
    }


    public void clickEnter() {
        btnEnter.click();
    }

    @Step(" Кликаем на лк")
    public HomePage PersonalAccountClick() {
       SelenideElement ButtonGoToPersonalAccount = $x(APPSCREENER_MAIN_ACCOUNT_PROFILE_BUTTON);
       SelenideElement UrlGoToPersonalAccountInHoverMenu = $x(APPSCREENER_MAIN_ACCOUNT_PROFILE_LINK_IN_HOVER);
       sleep(1000);
        if (UrlGoToPersonalAccountInHoverMenu.isDisplayed()) {
            UrlGoToPersonalAccountInHoverMenu.click();
            sleep(2000);
        }
        else if (ButtonGoToPersonalAccount.isDisplayed()){
            ButtonGoToPersonalAccount.click();
            sleep(2000);
        }
        return this;
    }

   public HomePage clikAccept (){
        acceptBtn.shouldBe(visible).click();
        return this;
    }

    public HomePage clickNext (){
        nextBtn.shouldBe(visible).click();
        return this;
    }


    public HomePage clickGetStartedBtn(){
        getStartedBtn.shouldBe(visible).click();
        sleep(2000);
        return this;
    }


    public HomePage clickAdministrationMenu(){
        adminBtn.shouldBe(visible).click();
        return this;
    }

    public CreateUserPage clickCreateNewUserBtn (){
        createNewUserBtn.shouldBe(Condition.enabled).click();
        return new CreateUserPage();
    }

    public HomePage checkUploadFilesButtonInMainPage() {
        sleep(2000);
        /*$x(APPSCREENER_INPUT_FOR_PROJECTS_URLS).shouldHave(visible);*/
        pageManager.getPage(BasePage.class).longWaitElement($x(APPSCREENER_INPUT_FOR_PROJECTS_URLS));
        return this;
    }
    public HomePage UploadFilesInMainPage(String ProjectPath) {
        sleep(2000);
        $x(APPSCREENER_DROP_ZONE_FOR_UPLOAD_FILES_FROM_LOCAL).shouldBe(visible, Duration.ofSeconds(20));
        sleep(1000);
        $x(APPSCREENER_INPUT_FOR_UPLOAD_FILES_FROM_LOCAL).uploadFile(new File(ProjectPath));
        sleep(1000);


        return this;
    }

    public HomePage clickStartAnalysisButton() {
        sleep(500);
        $x(APPSCREENER_INPUT_FOR_PROJECTS_URLS).scrollTo();
        sleep(1000);
        $x(APPSCREENER_START_ANALYSE_BUTTON).click();
        sleep(1000);
        if (PopupAfterStartAnalyse.isDisplayed()){
            sleep(3000);
            $x("//*[contains(text(), \"OK\")]").click();
            sleep(3000);

        }
        return this;
    }

    public HomePage checkInputForProjectUrls(){
        sleep(2000);
        $x(APPSCREENER_INPUT_FOR_PROJECTS_URLS).shouldBe(visible);

        return this;
    }
    public HomePage sendProjectUrlToInput(){

        $x(APPSCREENER_INPUT_FOR_PROJECTS_URLS).sendKeys(WEBGOAT_NET_FROM_GITHUB);

        return this;
    }
    public HomePage sendProjectGooglePlayUrlToInput(){
        $x(APPSCREENER_INPUT_FOR_PROJECTS_URLS).sendKeys(PROJECT_FROM_GOOGLE_PLAY);

        return this;
    }
    public HomePage sendProjectAppStoreUrlToInput(){
        $x(APPSCREENER_INPUT_FOR_PROJECTS_URLS).sendKeys(PROJECT_FROM_APP_STORE);

        return this;
    }
public HomePage resetUploadedProject(){
        sleep(500);
        $x(APPSCREENER_RESET_UPLOADED_PROJECT).scrollTo().shouldBe(visible).click();
        sleep(1000);
        return this;
    }

    public HomePage openSettingsForAnalyseProject() {
        $x("//button[@id = \"show_hide_scan_settings\"]").click();
        return this;
    }

    public HomePage deactivateCheckboxForOneLanguage(String NAME) {
        SelenideElement languageElementInSettings = $x("//span[contains(@class, \"mat-checkbox-label\")]/span[(@popoverclass = \"popover-class\") and (contains(text(), '" + NAME + "'))]");
        sleep(2000);
        languageElementInSettings.click();
        return this;
    }

    public HomePage openScatResults() {
        SelenideElement projectResults = $x("//div[contains(@class, \"swiper-slide-active\")]//a[@id = \"min_scan_results\"]");
        projectResults.click();
        return this;
    }
}
