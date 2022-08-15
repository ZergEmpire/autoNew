package com.smartdec.appscreener.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.webdriver.Url;
import com.smartdec.appscreener.pages.administration.users.CreateUserPage;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.smartdec.appscreener.utils.XpathStorage.*;
import static com.smartdec.appscreener.utils.ConstantStorage.*;

public class ProjectPage extends BasePage{


    public ProjectPage clickToProjectOverview() {

        SelenideElement overview = $x("//a[@id = \"project_overview\"]");
        sleep(2500);
        overview.click();
        sleep(1000);
        return this;
    }


    public ProjectPage iWillCheckTheScannedLanguageInTheScanResultsAfterInitialise(String NAME, DataTable dataTable) {
        SelenideElement ScannedLanguage = $x("//table[contains(@class, \"lang-stats-table\")]//td[contains(text(),'" + NAME + "')]");


        List<String> condition = dataTable.asList();
        System.out.println(condition.get(0));
        if (condition.get(0).equals("false")) {
            sleep(1000);
            ScannedLanguage.shouldNotBe(exist);
        }
        else if (condition.get(0).equals("true")){
            sleep(2000);
            ScannedLanguage.shouldBe(exist);
            ScannedLanguage.scrollTo().shouldBe(visible);
        }
        else {
            System.out.println("Для теста нет нужного condition, значение condition = " + condition.get(0) );
        }
      return this  ;
    }
}
