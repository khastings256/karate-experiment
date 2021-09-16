@ignore
Feature: sample karate test script
  for help, see: https://github.com/intuit/karate/wiki/IDE-Support

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  Scenario: This is to simulate a login
    * print "This is the run once feature"
    Given path 'users'
    When method get
    Then status 200
    * print __gatling
    * def first = response[0]
    * print "End of run once feature"

  