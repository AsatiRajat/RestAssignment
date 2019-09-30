package com.yash.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.exception.EmployeeNotFoundException;
import com.yash.models.Employee;
import com.yash.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public List<Employee> getEmployees() {
		logger.info("EmployeeController.getEmployees method execution started.");
		return employeeService.getEmployees();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json", "application/xml" })
	public Employee addEmployee(@Valid @RequestBody Employee employee) throws Exception {
		logger.info("EmployeeController.addEmployee method execution started.");
		Employee newEmployee = employeeService.createEmployee(employee);
		if (newEmployee == null) {
			throw new EmployeeNotFoundException("Employee does not exist.");
		}
		return newEmployee;
	}

	@RequestMapping(value = "/{empId}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public Employee getEmployee(@PathVariable("empId") Long empId) {
		logger.info("EmployeeController.getEmployee method execution started.");
		Employee employee = employeeService.findEmployeeById(empId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee does not exist.");
		}
		return employee;
	}

	@RequestMapping(value = "/{empId}", method = RequestMethod.PUT, produces = { "application/json",
			"application/xml" })
	public Employee updateEmployee(@PathVariable("empId") Long empId, @Valid @RequestBody Employee updatedEmployee) {
		logger.info("EmployeeController.updateEmployee method execution started.");
		Employee employee = employeeService.updateEmployeeById(empId, updatedEmployee);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee does not exist.");
		}
		return employee;
	}

	@RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("empId") Long empId) {
		logger.info("EmployeeController.deleteEmployee method execution started.");
		return employeeService.deleteEmployeeById(empId);
	}

}
