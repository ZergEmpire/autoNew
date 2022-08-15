package com.smartdec.appscreener.pages.administration.users.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class User {

    public String user_login;
    public String user_new_password;
    public String user_confirm_password;
    public String user_full_name;
    public String userEmail;
    public String userOrganization;
    public String userPosition;
    public boolean adminRoot = true;

    public User(String user_login, String user_new_password, String user_confirm_password, String user_full_name, String userEmail, String userOrganization, String userPosition, boolean adminRoot) {
        this.user_login = user_login;
        this.user_new_password = user_new_password;
        this.user_confirm_password = user_confirm_password;
        this.user_full_name = user_full_name;
        this.userEmail = userEmail;
        this.userOrganization = userOrganization;
        this.userPosition = userPosition;
        this.adminRoot = adminRoot;
    }


}
