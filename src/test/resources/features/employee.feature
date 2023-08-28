Feature: Employee CRUD Operations

  Scenario: Create an employee
    When the client creates an employee with first name "John" and last name "Doe"
    Then the response status code should be 201
    And the response should contain an employee with first name "John" and last name "Doe"
  
  Scenario: Get an employee by ID
    Given an employee with first name "Alice" and last name "Smith" exists
    When the client retrieves the employee by name "Alice"
    Then the response status code should be 200
    And the response should contain an employee with first name "Alice" and last name "Smith"

  Scenario: Update an employee
    Given an employee with first name "Bob" and last name "Johnson" exists
    When the client updates the employee with first name "Bobby" and last name "J."
    Then the response status code should be 200
    And the response should contain an employee with first name "Bobby" and last name "J."

  Scenario: Delete an employee
    Given an employee with first name "Eva" and last name "Brown" exists
    When the client deletes the employee by ID
    Then the response status code should be 204
    And the employee with first name "Eva" and last name "Brown" should not exist