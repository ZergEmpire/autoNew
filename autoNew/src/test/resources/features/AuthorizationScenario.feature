#language: en


Feature: authorization_feature

Scenario: 1.0 login in two accounts and check authorization function (Admin User)
    Given open two appScreener urls
    And login in default user account
    When click to icon personal account
    Then check Default user after logged in
    And switch to second url
    When the user is on the second open page, start logging in an Admin user
    When click to icon personal account
    And refresh page
    Then check admin user is logged in
    And switch to first url
    When click to icon personal account
    Then refresh page
    And check admin user is logged in
    And webDriver close

Scenario: 1.1 login in two accounts and check authorization function (Default User)
    Given open two appScreener urls
    And login in admin user account
    When click to icon personal account
    Then check admin user is logged in
    And switch to second url
    When the user is on the second open page, start logging in an Default user
    Then click to icon personal account
    And refresh page
    Then check Default user after logged in
    And switch to first url
    When click to icon personal account
    Then refresh page
    And check Default user after logged in
    And webDriver close

Scenario: 2.0 login in two accounts and do logout from default user
        Given open two appScreener urls
        And login in admin user account
        When click to icon personal account
        Then check admin user is logged in
        And switch to second url
        When the user is on the second open page, start logging in an Default user
        Then click to icon personal account
        And refresh page
        Then check Default user after logged in
        And log out from user
        When user log out - check login form is displayed
        And switch to first url
        Then refresh page
        Then user log out - check login form is displayed
        And webDriver close

Scenario: 2.1 login in two accounts and do logout from default user
        Given open two appScreener urls
        And login in admin user account
        When click to icon personal account
        Then check admin user is logged in
        And switch to second url
        When the user is on the second open page, start logging in an Default user
        Then click to icon personal account
        And refresh page
        Then check Default user after logged in
        And switch to first url
        When click to icon personal account
        And log out from user
        When user log out - check login form is displayed
        And switch to second url
        Then refresh page
        Then user log out - check login form is displayed
        And webDriver close

