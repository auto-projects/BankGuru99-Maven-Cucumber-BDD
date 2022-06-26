@features_bank_guru99
Feature: Register / Login / New Customer / Deposit

  @register_new_account
  Scenario: Create new account
    When Click on Here button
    Then Close the Ads
    And Input into 'Email ID' textbox
    And Click on 'Submit' button
    And Get value at 'User ID :' row
    And Get value at 'Password :' row
    Then Open Login Page

  @login_new_account
  Scenario: Login by new account
    Then Input into 'UserID' textbox
    And Input into 'Password' textbox
    And Click on 'LOGIN' button
    And Verify successful message displayed
    And Verify Manger Id displayed

  @new_customer
  Scenario Outline: Create new customer
    Given Open "New Customer" page
    Then Input into "Customer Name" textbox with data "<Customer Name>"
    And Click on "Gender" radio button
    And Input into "Date of Birth" textbox with data "<Date of Birth (In)>"
    And Input into "Address" text area with data "<Address>"
    And Input into "City" textbox with data "<City>"
    And Input into "State" textbox with data "<State>"
    And Input into "PIN" textbox with data "<PIN>"
    And Input into "Mobile Number" textbox with data "<Mobile Number>"
    And Input into "E-mail" textbox with data "<E-mail>"
    And Input into "Password" textbox with data "<Password>"
    Then Click on "Submit" button
    Then Successful message is displayed with "Customer Registered Successfully!!!"
    Then Get value at "Customer ID" row
    And The valid value displayed at "Customer Name" with data "<Customer Name>"
    And The valid value displayed at "Gender" with data "<Gender>"
    And The valid value displayed at "Birthdate" with data "<Date of Birth (Out)>"
    And The valid value displayed at "Address" with data "<Address>"
    And The valid value displayed at "City" with data "<City>"
    And The valid value displayed at "State" with data "<State>"
    And The valid value displayed at "Pin" with data "<PIN>"
    And The valid value displayed at "Mobile No." with data "<Mobile Number>"
    And The valid value displayed at "Email" with data "<E-mail>"
    Examples:
      | Customer Name | Gender | Date of Birth (In) | Date of Birth (Out) | Address | City | State | PIN | Mobile Number | E-mail | Password |
      | Customer Name | female   | 03/06/2000         | 2000-03-06          | Address | City | State | PIN | Mobile Number | E-mail | Password |






