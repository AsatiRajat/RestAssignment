package com.yash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.models.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee createEmployee(Employee employee);

	public Employee findEmployeeById(Long empId);

	public Employee updateEmployeeById(Long empId, Employee updatedEmployee);

	public String deleteEmployeeById(Long empId);

}
