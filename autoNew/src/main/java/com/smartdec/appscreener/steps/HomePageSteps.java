package com.smartdec.appscreener.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.smartdec.appscreener.managers.PageManager;
import com.smartdec.appscreener.pages.BasePage;
import com.smartdec.appscreener.pages.HomePage;
import com.smartdec.appscreener.pages.LoginPage;
import com.smartdec.appscreener.pages.administration.users.CreateUserPage;
import com.smartdec.appscreener.pages.administration.users.utils.Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.smartdec.appscreener.utils.XpathStorage.APPSCREENER_INPUT_FOR_PROJECTS_URLS;
import static com.smartdec.appscreener.utils.XpathStorage.APPSCREENER_INPUT_FOR_UPLOAD_FILES_FROM_LOCAL;

public class HomePageSteps {

//TODO - разобраться с PageManager при использовании page manager открываается несколько браузеров

   PageManager pageManager = PageManager.getPageManager();

//    LoginPage loginPage = new LoginPage();

    @Given("login page")
    public void loginPage() {
        open("https://appscreener-dev.ast.rt-solar.ru/");
    }


    @When("fill credentials")
    public void fillcredentials(Map<String, String> args) {
        sleep(2000);
        args.forEach((id, value)->pageManager.getPage(LoginPage.class).fillFieldSelenide(id,value));
        sleep(3000);
    }


    @Then("click button {string}")
    public void clickButton(String arg0) {
        pageManager.getPage(LoginPage.class).clickLoginButton()
                .confirmLicenseDocument()
                .confirmInstructionDocument();
    }

    @And("click button accept")
    public void clickButtonAccept() {
        pageManager.getPage(HomePage.class).clikAccept();
    }

    @And("click button next")
    public void clickButtonNext() {
        pageManager.getPage(HomePage.class).clickNext();
    }

    @And("click button getStarted")
    public void clickButtonGetStarted() {
        pageManager.getPage(HomePage.class).clickGetStartedBtn();
    }

    @And("click Administration")
    public void clickAdministration() {
        pageManager.getPage(HomePage.class).clickAdministrationMenu();
    }

    @Then("create new User")
    public void createNewUser() {
        pageManager.getPage(HomePage.class).clickCreateNewUserBtn();
    }


    @Then("fill user data")
    public void fillUserData() {
        pageManager.getPage(CreateUserPage.class).fillUsersFields(Users.adminUser);
    }

    @Then("check upload files button in main page")
    public void checkUploadFilesButtonInMainPage() {
        pageManager.getPage(HomePage.class).checkUploadFilesButtonInMainPage();    }

    @And("click start analysis button")
    public void clickStartAnalysisButton() {
        pageManager.getPage(HomePage.class).clickStartAnalysisButton();
    }



    @And("upload VulnerableWorld project files from local")
    public void uploadFilesVulnerableWorld() {
        sleep(2000);
        pageManager.getPage(HomePage.class).UploadFilesInMainPage("src/test/1.c.zip");
    }

    @Then("reset uploaded project")
    public void resetUploadedProject() {

        pageManager.getPage(HomePage.class).resetUploadedProject();
    }

    @And("send project url to input")
    public void sendProjectUrlToInput() {
        pageManager.getPage(HomePage.class).sendProjectUrlToInput();
    }

    @And("send project GooglePlay url to input")
    public void sendProjectGooglePlayUrlToInput() {
        pageManager.getPage(HomePage.class).sendProjectGooglePlayUrlToInput();
    }

    @And("send project AppStore url to input")
    public void sendProjectAppStoreUrlToInput() {
        pageManager.getPage(HomePage.class).sendProjectAppStoreUrlToInput();

    }

    //table[contains(@class, "lang-stats-table")]//td[contains(text(), "ABAP")]
    @When("I open settings for analyse")
    public void iOpenSettingsForAnalyse() {
        pageManager.getPage(HomePage.class).openSettingsForAnalyseProject();
    }

    @When("I open settings for analyse and deselect all check boxes in analyzed languages section")
    public void iOpenSettingsForAnalyseAndDeselectAllCheckBoxesInAnalyzedLanguagesSection() {
        SelenideElement showHideSettings = $x("//button[@id = \"show_hide_scan_settings\"]");
        SelenideElement deselectAllLanguageInSettings = $x("//app-select-all//a[@id = \"deselect_all\"]");

        showHideSettings.click();
        sleep(500);
        /*deselectAllLanguageInSettings.click();*/
    }

    @And("open scan results")
    public void openScanResults() {
        SelenideElement ProjectResults = $x("//div[contains(@class, \"swiper-slide-active\")]//a[@id = \"min_scan_results\"]");
        ProjectResults.click();
    }
}