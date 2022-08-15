#language: en


Feature: admin_feature

  Scenario: 1.1 create new admin user

#@When create_project
    Given login page
    When fill credentials
      | auth_login    | admin      |
      | auth_password | r@78bJM=45 |
    Then click button "Enter"
    And click button accept
    And click button next
    And click button getStarted
    And click Administration
    Then create new User
    Then fill user data
