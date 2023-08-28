package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByFirstNameAndLastName(String firstName, String lastName);

}
