package com.manageremployee.service;

import java.util.List;

import com.manageremployee.model.Employee;

public interface EmployeeService {
	 List < Employee > getAllEmployees();
	    void saveEmployee(Employee employee);
	    Employee getEmployeeById(long id);
	    void deleteEmployeeById(long id);

}
