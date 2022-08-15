package com.smartdec.appscreener.steps;

import com.smartdec.appscreener.managers.PageManager;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.smartdec.appscreener.pages.BasePage;
import com.smartdec.appscreener.pages.HomePage;
import com.smartdec.appscreener.pages.LoginPage;
import com.smartdec.appscreener.pages.ProfilePage;
import com.smartdec.appscreener.pages.administration.users.CreateUserPage;
import com.smartdec.appscreener.pages.administration.users.utils.Users;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class checkProjectsSteps {
    PageManager pageManager = PageManager.getPageManager();

    @And("login in special user for this case")
    public void loginPage(Map<String, String> args){
        sleep(2000);
        args.forEach((id, value)->pageManager.getPage(LoginPage.class).fillFieldSelenide(id,value));
        sleep(3000);
    }

    @Given("open appScreener url")
    public void openAppScreenerUrl() {
        pageManager.getPage(BasePage.class).openURL();
    }


    @Then("click login button")
    public void clickLoginButton() {
    }

    @And("create projects")
    public void createProjects(DataTable dataTable) {
        List<String> condition = dataTable.asList();
        int x = 734;
        SelenideElement buttonForCrateProjects = $x("//div[(@class = \"mat-tab-label-content\") and (text() = \"Создать пустой проект\")]");
        SelenideElement projectNameInput = $x("//input[@name = \"projectName\"]");
    while (x < 1000){
            sleep(4500);
            buttonForCrateProjects.shouldBe(visible).click();
            sleep(500);
            projectNameInput.shouldBe(visible).setValue("Проект" + x);
            sleep(1000);
            x++;
            $x("//button[@id = \"start_scan_or_create_project_1\"]").shouldBe(visible).click();
        }
    }
}
