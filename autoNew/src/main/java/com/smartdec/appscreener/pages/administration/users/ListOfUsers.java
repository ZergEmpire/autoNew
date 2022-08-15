package com.smartdec.appscreener.pages.administration.users;

import com.codeborne.selenide.SelenideElement;
import com.smartdec.appscreener.pages.BasePage;
import com.smartdec.appscreener.pages.administration.users.utils.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.*;

public class ListOfUsers extends BasePage {
    @FindBy(id = "users_search")
    WebElement searchUsers;

    @FindBy(id = "users_go_to_user")
    WebElement userAtList;

    protected SelenideElement listOfUsersBtn = $("#users");

    @Step("Проверка что пользователь создан")
    public ListOfUsers searchUsersFromList(User user) {
        searchUsers.click();
        searchUsers.sendKeys(user.user_login);
        // Assertions.assertTrue(userAtList.getAttribute("innerText").equalsIgnoreCase(user.user_login));
        assertAll("Пользватель не найден", () -> {
            assertNotNull(userAtList.getAttribute("innerText"));
            assertTrue(userAtList.getAttribute("innerText").equalsIgnoreCase(user.user_login));
        });
        return this;
    }


    @Step("Нажать на \"Список пользователей\"")
    public ListOfUsers listOfUsersClick() {
        listOfUsersBtn.click();
        return new ListOfUsers();
    }



}
