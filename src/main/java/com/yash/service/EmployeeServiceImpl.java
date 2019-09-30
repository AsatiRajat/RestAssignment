package com.yash.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.exception.EmployeeNotFoundException;
import com.yash.models.Employee;
import com.yash.repositiory.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		logger.info("EmployeeServiceImpl.getEmployees method execution started.");
		return employeeRepository.findAll();
	}

	public Employee createEmployee(Employee employee) {
		logger.info("EmployeeServiceImpl.createEmployee method execution started.");
		return employeeRepository.save(employee);
	}

	public Employee findEmployeeById(Long empId) {
		logger.info("EmployeeServiceImpl.findEmployeeById method execution started.");
		return employeeRepository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist."));
	}

	public Employee updateEmployeeById(Long empId, Employee updatedEmployee) {
		logger.info("EmployeeServiceImpl.updateEmployeeById method execution started.");
		return employeeRepository.findById(empId).map(employee -> {
			employee.setAddress(updatedEmployee.getAddress());
			employee.setAge(updatedEmployee.getAge());
			employee.setContactNumber(updatedEmployee.getContactNumber());
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setLastName(updatedEmployee.getLastName());
			employee.setSalary(updatedEmployee.getSalary());
			return employeeRepository.save(employee);
		}).orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist."));
	}

	public String deleteEmployeeById(Long empId) {
		logger.info("EmployeeServiceImpl.deleteEmployeeById method execution started.");
		employeeRepository.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist."));
		employeeRepository.deleteById(empId);
		return "Employee deleted succeessfully!";
	}

}
