Feature: Testing Yandex.Market

  Scenario: Searching 1
    Given I open the Firefox browser and expand to full screen
    And I open yandex.ru
    When I select "Маркет"(market.yandex.ru)
    And I select the section "Компьютеры"
    And I select the subsection "Ноутбуки"
    And I go to advanced search
    And I set the search parametr 30000 rubles
    And I choose the manufacturers HP and Lenovo
    And I click the Apply button
    Then I check that the items on page 10
    And I remember the first item in the list
    And I enter the stored value in the search string
    And I find and verify that the name of the product corresponds to the stored value
    And I close the browser
