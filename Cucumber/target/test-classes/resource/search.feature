#Author: developer@companydomain.com
#Keywords Summary : this feature shall search a product on flipkaert
#Feature: List of scenarios.
#Scenario: Searching a product in ecommerce platform
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Flipkart Search
  I want to write this  feature for searching a product

  @tag1
  Scenario: Search a product
    Given I have a search field n the flipkart page
    When I search for a product namedpg "laptop"
    And I entered the price as "30300"
    Then Product with name "laptop" should be displayed


#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step
#
#    Examples: 
#      | name  | value | status  |
#     | name1 |     5 | success |
#      | name2 |     7 | Fail    |
