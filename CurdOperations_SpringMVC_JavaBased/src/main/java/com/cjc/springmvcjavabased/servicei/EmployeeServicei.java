package com.cjc.springmvcjavabased.servicei;

import java.util.List;

import com.cjc.springmvcjavabased.model.Employee;

public interface EmployeeServicei {

	public void saveEmployee(Employee e);

	public List<Employee> updateEmployee(Employee e);

	public Employee editEmployee(int id);

	public List<Employee> deleteEmployee(int id);

	public List<Employee> loginEmployee(String username, String password);
	
}
