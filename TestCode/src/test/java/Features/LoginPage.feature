Feature: Login Page features Testing

 Scenario: User login with existing Credentials
    Given The homepage is open
    And user clicks on Login
    When User enters "<Emailaddress>", "<Password>"
      | Emailaddress  | Password |
      | test123@gmail.com | tester@123 |
      | testabc@gmail.com | tester!123|
    And user clicks on Login with Email address
    Then User should be able to login successfully and see the firstname















