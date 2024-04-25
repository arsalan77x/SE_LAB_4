@tag
Feature: Calculator

  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3


  Scenario Outline: add two numbers
    Given Two input values, <first> and <second>
    When I add the two values
    Then I expect the result <result>

    Examples:
      | first | second | result |
      | 1     | 12     | 13     |
      | -1    | 6      | 5  	|
      | 2     | 2      | 4	    |

  Scenario: multiple two numbers
    Given Two input values, -3 and 2
    When I multiple the values
    Then I expect the result -6

  Scenario: divide two numbers
    Given Two input values, -3 and 1
    When I divide the values
    Then I expect the result -3

  Scenario: power two numbers
    Given Two input values, -3 and 3
    When I power the values
    Then I expect the result -27

  Scenario Outline: opt two numbers
    Given Input values, <first> and <second> and <opt>
    Then I expect the result <result>

    Examples:
      | first | second | opt | result |
      | 6 | 2 | * | 12 |
      | 6 | 2 | / | 3 |
      | 6 | 2 | ^ | 36 |
      | 6 | 0 | / | error |
      | 6 | -2 | / | -3 |
      | 6 | -2 | # | error |
      | 3 | -2 | ^ | 1     |
    #all values were int so: 3 ^ -2 = 1/9 ~ 1
