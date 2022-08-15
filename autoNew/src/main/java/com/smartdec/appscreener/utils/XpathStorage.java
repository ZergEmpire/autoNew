package com.smartdec.appscreener.utils;
import static com.smartdec.appscreener.utils.ConstantStorage.*;


public class XpathStorage {
    //Логотип
public static final String APPSCREENER_LOGO_LOGIN_PAGE = "//div[@class = \"logo\"]";
    //Форма для логина на странице логина
public static final String APPSCREENER_LOGIN_FORM_IN_LOGIN_PAGE = "//div[contains(@class, \"login-card\")]";

public static final String APPSCREENER_LOGIN_INPUT_IN_LOGIN_PAGE = "//input[@id = \"auth_login\"]";

public static final String APPSCREENER_PASSWORD_INPUT_IN_LOGIN_PAGE = "//input[@id = \"auth_password\"]";

public static final String APPSCREENER_LOGIN_BUTTON_IN_LOGIN_PAGE = "//button[@id = \"login-auth_login_button\"]";

public static final String APPSCREENER_INCORRECT_LOGIN_ALERT_IN_LOGIN_PAGE = "//div[contains(text(), \"Неверный логин\")]";

public static final String APPSCREENER_FORGOT_PASSWORD_BUTTON_IN_LOGIN_PAGE = "//a[contains(text(), \"Забыли пароль\")]";

public static final String APPSCREENER_FEEDBACK_FORM_IN_LOGIN_PAGE = "//mat-dialog-container[@id = \"mat-dialog-0\"]";

public static final String APPSCREENER_BUTTON_TO_CONFIRM_LICENSE_DOCUMENT = "//button[@id = \"eula-appscreener-dialog_accept_eula\"]";

public static final String APPSCREENER_BUTTON_TO_CONFIRM_INFORMATION_TUTORIAL_NEXT = "//button[@id = \"information_tutorial_next_tutorial\"]";
public static final String APPSCREENER_BUTTON_TO_CONFIRM_INFORMATION_TUTORIAL_FINISH = "//button[@id = \"information_tutorial_get_started_tutorial\"]";

public static final String APPSCREENER_INFORMATION_TUTORIAL = "//mat-dialog-container[@id = \"mat-dialog-1\"]";

public static final String APPSCREENER_LICENSE_DOCUMENT = "//mat-dialog-container[@id = \"mat-dialog-0\"]";

public static final String APPSCREENER_ACCOUNT_STATUS_FORM = "//mat-dialog-container//div[contains(@class, \"mat-dialog-actions\")]";

public static final String APPSCREENER_ACCOUNT_STATUS_FORM_BUTTON_CONFIRM = "//mat-dialog-container//div[contains(@class, \"mat-dialog-actions\")]/button[not(contains(@class, \"btn-primary-outline\"))]";
public static final String APPSCREENER_MAIN_ACCOUNT_PROFILE_BUTTON = "//div[@class = \"my-account-cont\"]/a[@id = \"main_profile_tab\"]";
public static final String APPSCREENER_MAIN_ACCOUNT_PROFILE_LINK_IN_HOVER = "//div[@class = \"my-account-cont\"]/a[@id = \"main_profile_tab\"]";

public static final String APPSCREENER_PROFILE_LOGIN_USER_DEFAULT_USER = "//h3[@class = \"user-login\" and (contains(text(), \"appScreener-user1\"))]";
public static final String APPSCREENER_PROFILE_LOGIN_USER_ADMIN_USER = "//h3[@class = \"user-login\" and (contains(text(), \"appscreener-admin\"))]";

public static final String APPSCREENER_PROFILE_LOGOUT_BUTTON = "//button[@id = \"profile_logout\"]";
public static final String APPSCREENER_PROFILE_USERNAME_MENU_LOGOUT_BUTTON = "//a[@id = \"account_info_sign_out\"]";
public static final String APPSCREENER_START_ANALYSE_BUTTON = "//button[@id=\"start_scan_or_create_project_1\"]";
public static final String APPSCREENER_INPUT_FOR_PROJECTS_URLS = "//input[@id = \"app_link_or_repository_path\"]";
public static final String APPSCREENER_INPUT_FOR_UPLOAD_FILES_FROM_LOCAL = "//div[@class = \"content\"]/input[@type= \"file\"]";

public static final String APPSCREENER_DROP_ZONE_FOR_UPLOAD_FILES_FROM_LOCAL = "//div[@class = \"drop-zone\"]";
public static final String APPSCREENER_POPUP_AFTER_START_ANALYSE = "//mat-dialog-container//div[contains(@class, \"mat-dialog-actions\")]";
public static final String APPSCREENER_RESET_UPLOADED_PROJECT = "//a[contains(@class, \"text-nowrap\")]/span";

// css selectors

}
