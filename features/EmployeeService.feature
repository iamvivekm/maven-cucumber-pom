Feature: Checking the Employee Service endpoints

  @scenario3
  Scenario: Validate the Employee listing
    Given path 'v1/employees'
    And using 'GET' method
    And 'enable' request logging
    When I send request
    Then status code is 200

  @scenario4
  Scenario: Validate the Employee listing
    Given path 'v1/employee/1'
    And using 'GET' method
    When I send request
#    Then status code is 200
    And response contains below values
      | jsonPath           | value       |
      | status             | success     |
      | data.id            | 1           |
      | data.employee_name | Tiger Nixon |