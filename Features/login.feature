Feature: Login

@sanity
  Scenario: Login with valid credentials
    Given User launch the browser
    When user opens the URL "https://admin-demo.nopcommerce.com/login"
    And user enters email "admin@yourstore.com" and password "admin"
    And user clicks login button
    Then user should navigated to home page and title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout button
    Then user navigated to login page and title of the page should be "Your store. Login"
    And close the browser

@regression
  Scenario Outline: Login with multiple credentials(Data Driven)
    Given User launch the browser
    When user opens the URL "https://admin-demo.nopcommerce.com/login"
    And user enters email "<email>" and password "<password>"
    And user clicks login button
    Then user should navigated to home page and title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout button
    Then user navigated to login page and title of the page should be "Your store. Login"
    And close the browser

    Examples: 
      | email               |  | password |
      | admin@yourstore.com |  | admin    |
      | admin@yourstore.com |  | admin123 |
