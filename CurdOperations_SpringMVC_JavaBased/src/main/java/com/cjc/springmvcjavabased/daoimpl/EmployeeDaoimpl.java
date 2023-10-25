package com.cjc.springmvcjavabased.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjc.springmvcjavabased.daoi.EmployeeDaoi;
import com.cjc.springmvcjavabased.model.Employee;

public class EmployeeDaoimpl implements EmployeeDaoi {

	@Autowired
	SessionFactory sf;

	@Override
	public void saveEmployee(Employee e) {
		Session session= sf.openSession();
		session.save(e);
		session.beginTransaction().commit();
		System.out.println("In Database...!");
		
	}
	public List<Employee> getEmployee()
	{
		Session session = sf.openSession();
		List<Employee> list=session.createQuery("from Employee").getResultList();
		return list;
		
	}
	@Override
	public List<Employee> loginEmployee(String username, String password) {
		if(username.equals("admin") && password.equals("root"))
		{
			return getEmployee();
		}
		else {
			Session session =sf.openSession();
			Query<Employee>query =session.createQuery("from Employee where usrname=? and password=?");
			query.setParameter(0, username);
			query.setParameter(1, password);
			return query.getResultList();
		}	
	}
	@Override
	public List<Employee> deleteEmployee(int id) {
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query<Employee> query = session.createQuery("delete from Employee where id = :id");
	    query.setParameter("id", id);
	    query.executeUpdate();
	    tx.commit();
	    return getEmployee();
	}
	@Override
	public Employee editEmployee(int id) {
		Session session = sf.openSession();
		Employee e =session.get(Employee.class, id);
		
		return e;
	}
	@Override
	public List<Employee> updateEmployee(Employee e) {
		Session session =sf.openSession();
		session.update(e);
		session.beginTransaction().commit();
		return getEmployee();
	}
	
}
