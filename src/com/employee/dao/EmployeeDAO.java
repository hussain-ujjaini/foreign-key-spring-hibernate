package com.employee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.department.vo.DepartmentVO;
import com.employee.vo.EmployeeVO;

@Repository
public class EmployeeDAO {
	@Autowired
	SessionFactory sf;
	public void insert(EmployeeVO vo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(vo);
		tx.commit();
		s.close();
	}
	public List searchByEmployeeName(EmployeeVO vo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("select employeeId,firstName,lastName,user.username,department.departmentName from EmployeeVO where firstName like '"+vo.getFirstName()+"%'");
		List searchedEmployee = query.list();
		tx.commit();
		s.close();
		return searchedEmployee;
	}
	public List searchByDepartment(EmployeeVO vo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("select employeeId,firstName,lastName,user.username,department.departmentName from EmployeeVO where department.departmentId = '"+vo.getDepartment().getDepartmentId()+"'");
		List searchedEmployee = query.list();
		tx.commit();
		s.close();
		return searchedEmployee;
	}
	public void deleteEmployee(EmployeeVO vo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.delete(vo);
		tx.commit();
		s.close();
	}
	public int getDepartmentId(EmployeeVO vo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("select department.departmentId from EmployeeVO where employeeId = '"+vo.getEmployeeId()+"'");
		int departmentId = (int) query.uniqueResult();
		tx.commit();
		s.close();
		return departmentId;
	}
	public int getUserId(EmployeeVO vo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("select user.userId from EmployeeVO where employeeId = '"+vo.getEmployeeId()+"'");
		int userId = (int) query.uniqueResult();
		tx.commit();
		s.close();
		return userId;
	}
}
