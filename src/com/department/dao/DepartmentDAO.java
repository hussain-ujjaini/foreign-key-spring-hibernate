package com.department.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.department.vo.DepartmentVO;

@Repository
public class DepartmentDAO {
	@Autowired
	SessionFactory sf;
	public List listDepartments() {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("from DepartmentVO");
		List departmentList=query.list();
		tx.commit();
		s.close();
		return departmentList;
	}
	public void delete(DepartmentVO depvo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.delete(depvo);
		tx.commit();
		s.close();
	}

}
