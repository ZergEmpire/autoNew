#language: en
Feature: check1000Projects
  Background:

@checkProjects
    Scenario: try login in
      Given  open appScreener url
      And login in special user for this case
    | auth_login    |userForTest1000Projects |
    | auth_password | 1234 |
  Then click button "Enter"
  And create projects
    |1000|
  And webDriver close