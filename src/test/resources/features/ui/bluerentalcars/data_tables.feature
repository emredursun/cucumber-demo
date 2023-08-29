@data_tables
Feature: Admin Login
  Scenario: Login with admin credentials
#Do i have reusable step definition??? Yes
#  admin@bluerentalcars.com
    Given user is on the login page
    And user login dropdown
    And user enters admin_username and admin_password
      |username     |admin@bluerentalcars.com|
      |password     |12345                   |
    When user clicks on login button
    Then verify the login is successful
    Then close the app