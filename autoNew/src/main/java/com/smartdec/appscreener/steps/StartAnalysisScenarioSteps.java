package com.smartdec.appscreener.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.smartdec.appscreener.managers.PageManager;
import com.smartdec.appscreener.pages.BasePage;
import com.smartdec.appscreener.pages.HomePage;
import com.smartdec.appscreener.pages.ProjectPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StartAnalysisScenarioSteps {
    PageManager pageManager = PageManager.getPageManager();

    @Then("upload {string} project files from {string}")
    public void uploadProjectFilesFrom(String Name, String PathFolder) {
            sleep(2000);
            pageManager.getPage(HomePage.class).UploadFilesInMainPage(PathFolder);
        }

    @Then("i will check the scanned language {string} in the scan results")
    public void iWillCheckTheScannedLanguageInTheScanResults(String NAME) {
        SelenideElement languageScanTable = $x("//table [contains(@class, \"lang-stats-table\")]");

        languageScanTable.scrollTo();



    }

    @Then("i will check the scanned language {string} in the scan results after initialise")
    public void iWillCheckTheScannedLanguageInTheScanResultsAfterInitialise(String NAME, DataTable dataTable) {
        pageManager.getPage(ProjectPage.class).iWillCheckTheScannedLanguageInTheScanResultsAfterInitialise(NAME, dataTable);
    }

    @And("open project overview")
    public void clickToProjectOverview() {
        pageManager.getPage(ProjectPage.class).clickToProjectOverview();
    }

    @Then("i will deactivate checkbox {string} language")
    public void iWillDeactivateCheckboxLanguage(String NAME) {
        pageManager.getPage(HomePage.class).deactivateCheckboxForOneLanguage(NAME);
    }

    @And("click scan Result")
    public void clickScanResult() {
        pageManager.getPage(HomePage.class).openScatResults();
    }

    @And("click main page")
    public void clickMainPage() {
        pageManager.getPage(BasePage.class).clickMainPage();
    }

    @And("text about correct case started")
    public void textAboutCorrectCaseStarted() {
        System.out.println("Запущен первый тест кейс");
    }
}
