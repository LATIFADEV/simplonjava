package com.manageremployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageremployee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
