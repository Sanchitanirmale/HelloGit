package com.cjc.springmvcjavabased.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.springmvcjavabased.daoi.EmployeeDaoi;
import com.cjc.springmvcjavabased.model.Employee;

@Service
public class EmployeeServiceimpl implements EmployeeDaoi
{

	@Autowired
	EmployeeDaoi edi;
	@Override
	public void saveEmployee(Employee e)
	{
		edi.saveEmployee(e);
	}
	@Override
	public List<Employee> loginEmployee(String username, String password) {
		//List<Employee> deleteEmployee(username, password);
		return edi.loginEmployee(username, password);
	}
	@Override
    public List<Employee> deleteEmployee(int id) {
		List<Employee> list =edi.deleteEmployee(id);
		
		return list;
	}
	@Override
	public Employee editEmployee(int id) {
		Employee e =edi.editEmployee(id);
		
		return e;
	}
	@Override
	public List<Employee> updateEmployee(Employee e) {
		
		return edi.updateEmployee(e);
	}	
	
	
	

}
