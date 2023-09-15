Feature: Kerv task automation

  Scenario Outline: Enroll for senior automation
    Given User navigates to the Kerv site
    When User Accepts cookies
    And User clicks on careers
    And User selects "<location>" India

    And User selects "<type>" Full time

    And User selects "<remote>" Hybrid

    And user enter "<jobtitle>" to search

    And User selects job
    And User enters profile details
      | FirstName    | Santosh                     |
      | LastName     | Chavan                      |
      | Email        | Santoshchavan1990@gmail.com |
      | MobileNumber |  7411344278                 |
    Then should display message Thank you for your application

    Examples:
      | location | type      |  | remote | jobtitle                         |
      | India    | Full Time |  | Hybrid | Senior Test Engineer- Automation |


