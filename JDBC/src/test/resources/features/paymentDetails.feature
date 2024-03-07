@paymentDetails @db
Feature: Payment table automation features

  Scenario Outline: Get a list of all films
    Given the payment service is up and running
    When I request a list of all payment
    Then I should receive a list containing at least '<columnCount>' columns
    Examples:
      | columnCount |
      | 5000        |
      | 7500        |
      | 10000       |
      | 12500       |
      | 9000        |


  Scenario Outline: Verification of getting true customer by given customerId
    Given the payment service is up and running
    When I request a list rentals by given customerId '<customerId>'
    Then I should receive a list containing only given customerId '<customerId>'
    Examples:
      | customerId |
      | 122        |
      | 395        |
      | 449        |
      | 248        |
      | 124        |
      | 584        |
      | 652        |
      | 985        |

  Scenario Outline: Verification of true table by given amount
    Given the payment service is up and running
    When I request a list rentals by given amount '<amount>' and situation '<lessOrMore>'
    Then I should receive a list contains whose amount '<amount>' and direction '<lessOrMore>'
    Examples:
      | amount | lessOrMore |
      | 2      | >          |
      | 1.5    | >          |
      | 2.99   | <          |
      | 4.99   | <=         |
      | 3      | >          |
      | 7      | >=         |
      | 1      | <          |
      | 4.99   | =          |






