package com.smartdec.appscreener.pages.administration.users.utils;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Users {

    public User user;
    public boolean isAdmin;
    public static User adminUser = new User("appscreener-admin99",
            "CjcTZP1HZanK",
            "CjcTZP1HZanK",
            "Администратор тест",
            "appscreener-admin@rt-solar.ru",
            "Компания тест",
            "менеджер",
            true);

    public static User testUser = new User("appscreener-user111",
            "83eBy0AE5mFr",
            "83eBy0AE5mFr",
            "Пользователь для тестирования",
            "appscreener-user-1@rt-solar.ru",
            "Офис тест",
            "стажёр",
            false);


}
