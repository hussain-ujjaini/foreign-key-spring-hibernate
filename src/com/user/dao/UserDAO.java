package com.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.vo.UserVO;
@Repository
public class UserDAO {
	@Autowired
	SessionFactory sf;
	public void delete(UserVO uservo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.delete(uservo);
		tx.commit();
		s.close();
	}
}
