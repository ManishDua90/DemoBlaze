Feature: Add laptop to cart and complete the purchase

  Scenario: Place an order for laptop
    Given "Laptops" screen is open
    When User adds "Sony vaio i5" to cart
    And User adds "Sony vaio i7" to cart
    And Deletes "Sony vaio i7" laptop from the cart
    And Clicks Place order and fills details
    | Name     | Country | City  | CreditCard   | Month | Year |
    | TestName | India   | Delhi | 113344556677 | 8     | 2028 |
    Then Order gets placed

   