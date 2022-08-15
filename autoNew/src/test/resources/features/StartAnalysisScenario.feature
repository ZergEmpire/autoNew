#language: en
Feature: startAnalysis_feature
Background:
@First
  Scenario: 1.0 Load project from local, remove project and load project from local again.
  Given  open appScreener url and login in admin user
  And text about correct case started
  When upload VulnerableWorld project files from local
  Then reset uploaded project
  And upload VulnerableWorld project files from local
  And click start analysis button
  Then wait scan finish
  And webDriver close
@Second
Scenario: 1.1 Load project from URL and Start analyse
  Given  open appScreener url and login in admin user

  And send project url to input
  And click start analysis button
  Then wait scan finish
  And webDriver close

Scenario: 1.2 Load project from GooglePlay URL and Start analyse
  And send project GooglePlay url to input
  And click start analysis button
  Then wait scan finish
  And webDriver close
Scenario: 1.3 Load project from AppStore URL and Start analyse
  And send project AppStore url to input
  And click start analysis button
  Then wait scan finish
  And webDriver close
 #Scenario: 1.4
@Smoke
Scenario Template: 2.0 Scan languages in project
  Given  open appScreener url and login in admin user

  Then upload "<NAME>" project files from "<PathFolder>"
   When I open settings for analyse
  Then i will deactivate checkbox "<NAME>" language
    And click start analysis button
    Then wait scan finish
  And click scan Result
  And open project overview
  Then i will check the scanned language "<NAME>" in the scan results after initialise
  |false|
  And click main page
  Then  upload "<NAME>" project files from "<PathFolder>"
  And click start analysis button
  Then wait scan finish
  And click scan Result
  And open project overview
  Then i will check the scanned language "<NAME>" in the scan results after initialise
  |true|
  And webDriver close
  Examples:
    |NAME|PathFolder|
    |Apex|src/test/VulnarebleZip's/apex.zip|
    |ABAP|src/test/VulnarebleZip's/abap.zip|
    |C#|src/test/VulnarebleZip's/csharp.zip|
    |COBOL|src/test/VulnarebleZip's/cobol.zip|
    |Config files|src/test/VulnarebleZip's/conf.zip|
    |Dart|src/test/VulnarebleZip's/dart.zip|
    |Delphi|src/test/VulnarebleZip's/delphi.zip|
    |Go|src/test/VulnarebleZip's/go.zip|
    |Groovy|src/test/VulnarebleZip's/groovy.zip|
    |HTML5|src/test/VulnarebleZip's/html5.zip|
    |JavaScript|src/test/VulnarebleZip's/javascript.zip|
    |LotusScript|src/test/VulnarebleZip's/lotus.zip|
    |Pascal|src/test/VulnarebleZip's/pascal.zip|
    |PHP|src/test/VulnarebleZip's/php.zip|
    |PL/SQL|src/test/VulnarebleZip's/plsql.zip|
    |Python|src/test/VulnarebleZip's/python2.zip|
    |Perl|src/test/VulnarebleZip's/perl.zip|
    |Ruby|src/test/VulnarebleZip's/ruby.zip|
    |Rust|src/test/VulnarebleZip's/rust.zip|
    |Solidity|src/test/VulnarebleZip's/solidity.zip|
    |Swift|src/test/VulnarebleZip's/swift.zip|
    |T-SQL|src/test/VulnarebleZip's/tsql.zip|
    |TypeScript|src/test/VulnarebleZip's/typescript.zip|
    |VB.NET|src/test/VulnarebleZip's/vbnet.zip|
    |VBA|src/test/VulnarebleZip's/vba.zip|
    |VBScript|src/test/VulnarebleZip's/vbscript.zip|
    |Visual Basic 6|src/test/VulnarebleZip's/visualbasic6.zip|
    |1C|src/test/VulnarebleZip's/1c.zip|







