Feature: Hello World (iOS)

  Scenario: Computing the sum of two numbers
  As a user When I add two numbers 22 and 33
  I should see the sum 55

  When I launch iOS app
  And I choose to enter "22" and "33"
  When I tap on Compute Sum
  Then I should see the result "55"
