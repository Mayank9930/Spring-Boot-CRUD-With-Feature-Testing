package com.example.demo.stepdefs;

import com.example.demo.TestClass;
import com.example.demo.entities.Employee;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@CucumberContextConfiguration
@SpringBootTest(classes = TestClass.class)
public class EmployeeStepDefs {

//    private EmployeeRepository employeeRepository;

    private ResponseEntity<Employee> response ;
    
    private static String URL_PATH =  "http://localhost:8080/api/employees";
    
    @Autowired
    private RestTemplate restTemplate;  // Adjust this to your actual RestTemplate bean

    @When("the client creates an employee with first name {string} and last name {string}")
    public void theClientCreatesAnEmployeeWithFirstNameAndLastName(String firstName, String lastName) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        response = restTemplate.postForEntity(URL_PATH, newEmployee, Employee.class);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(HttpStatus.valueOf(statusCode), response.getStatusCode());
    }

    @And("the response should contain an employee with first name {string} and last name {string}")
    public void theResponseShouldContainAnEmployeeWithFirstNameAndLastName(String expectedFirstName, String expectedLastName) {
        Employee createdEmployee = response.getBody();
        assertNotNull(createdEmployee);
        assertEquals(expectedFirstName, createdEmployee.getFirstName());
        assertEquals(expectedLastName, createdEmployee.getLastName());
    }

    @Given("an employee with first name {string} and last name {string} exists")
    public void anEmployeeWithFirstNameAndLastNameExists(String firstName, String lastName) {
        Employee existingEmployee = new Employee();
        existingEmployee.setFirstName(firstName);
        existingEmployee.setLastName(lastName);
        restTemplate.postForEntity(URL_PATH, existingEmployee, Employee.class);
    }

    @When("the client retrieves the employee by name {string}")
    public void theClientRetrievesTheEmployeeByID(String Name) {
    	response = restTemplate.getForEntity(URL_PATH, Employee.class);
    }

    @When("the client updates the employee with first name {string} and last name {string}")
    public void theClientUpdatesTheEmployeeWithFirstNameAndLastName(String firstName, String lastName) {
//        Employee existingEmployee = employeeRepository.findAll().get(0);
//        existingEmployee.setFirstName(firstName);
//        existingEmployee.setLastName(lastName);
//        restTemplate.put("/api/employees/" + existingEmployee.getId(), existingEmployee);
    }

    @When("the client deletes the employee by ID")
    public void theClientDeletesTheEmployeeByID() {
//        Employee existingEmployee = employeeRepository.findAll().get(0);
//        restTemplate.delete("/api/employees/" + existingEmployee.getId());
    }

    @Then("the employee with first name {string} and last name {string} should not exist")
    public void theEmployeeWithFirstNameAndLastNameShouldNotExist(String firstName, String lastName) {
//        Employee deletedEmployee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
//        assertNull(deletedEmployee);
    }
}
