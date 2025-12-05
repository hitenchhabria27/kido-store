Feature: Checkout
  Background: Logged in and Product added to cart
    Given I visited login page
    Then I entered username "user1@gmail.com" and password "abcd1234"
    And I logged in successfully
    When I clicked on study material tab
    And Opened random product from study material tab
    And I added product to cart
    Then Successfully added to cart message was visible
    And I opened cart
    Then Added product was visible in cart

    Scenario: Proceed to Checkout
      Given I clicked on Proceed to Checkout button
      Then I clicked on Add Address Button
      And I entered Address
      Then Successfully added Address message was visible


