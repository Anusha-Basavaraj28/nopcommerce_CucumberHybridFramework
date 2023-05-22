Feature: Customers

  Background: common steps for eachscenario
    Given User launch the browser
    When user opens the URL "https://admin-demo.nopcommerce.com/login"
    And user enters email "admin@yourstore.com" and password "admin"
    And user clicks login button
    Then user should navigated to home page and title should be "Dashboard / nopCommerce administration"
    When user clicks on Customer menu
    And user clicks on customer menu item

@sanity
  Scenario: Add a new customer
    And user click on Add new button
    Then user shuld view the Add new customer page
    When user enters customer details
    And user clicks on Save button
    Then user should see the confirmation message "The new customer has been added successfully."
    And close the browser

@regression
  Scenario: Search customer by using Emailid
    When user enters customer email
    And user clicks on the search button
    Then user should found email in the search table
    And close the browser

@regression
  Scenario: Search customer by using First name and last name
    When user enters customer First name and last name
    And user clicks on the search button
    Then user should found First name and last name in the search table
    And close the browser
