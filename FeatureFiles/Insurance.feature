Feature: Insurance Application

  @RegressionTesting
  Scenario: Travel Insurance
    Given User is on the insurance website
    When User enters the studentInsurance Details
    Then Display the Top 3 Lowest Insurance Plans

  @RegressionTesting
  Scenario: Car Insurance
    Given User navigates to car insurance Page
    When User provides car Insurance Details
    Then Display the Error Message

  @RegressionTesting
  Scenario: Health Insurance
    Given User Navigates to HomePage
    When User clicks on Insurance Products
    Then Display the List of Insurance Items List

  @SmokeTesting
  Scenario: Smoke Insurance Plan
    Given User Navigates to insurance page
    When User enters student details
    And User navigate to car insurance page
    And User enters car details
    Then User checks health insurance page
