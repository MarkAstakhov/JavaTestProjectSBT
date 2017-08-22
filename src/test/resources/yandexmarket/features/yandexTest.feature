@All
Feature: Testing Yandex.Market

  @1
  Scenario: First searching
    Given I open the Firefox browser and expand to full screen
    And I open yandex.ru
    When I select "Маркет"(market.yandex.ru)
    And I select the section "Компьютеры"
    And I select the subsection "Ноутбуки"
    And I go to advanced search
    And I set the search price parametr to 30000 rubles
    And I choose the manufacturers HP, Lenovo
    And I click the Apply button
    Then I check that the items on page 12
    And I remember the item number 1 from the list
    And I enter the stored value in the search string
    And I find and verify that the name of the product corresponds to the stored value

  @2
  Scenario: Second searching
    Given I open the Firefox browser and expand to full screen
    And I open yandex.ru
    When I select "Маркет"(market.yandex.ru)
    And I select the section "Компьютеры"
    And I select the subsection "Ноутбуки"
    And I go to advanced search
    And I set the search price parametr from 20000 rubles
    And I set the search price parametr to 25000 rubles
    And I choose the manufacturers Acer, DELL
    And I click the Apply button
    Then I check that the items on page 12
    And I remember the item number 1 from the list
    And I enter the stored value in the search string
    And I find and verify that the name of the product corresponds to the stored value