package com.cjc.springmvcjavabased.daoi;

import java.util.List;

import com.cjc.springmvcjavabased.model.Employee;

public interface EmployeeDaoi {

	public void saveEmployee(Employee e);

	List<Employee> loginEmployee(String username, String password);

	List<Employee> deleteEmployee(int id);

	Employee editEmployee(int id);

	List<Employee> updateEmployee(Employee e);
}
