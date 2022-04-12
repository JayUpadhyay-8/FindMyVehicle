package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.RegisterVO;

@Repository

public class RegisterDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void insertRegister(RegisterVO registerVO) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(registerVO);
		transaction.commit();
		session.close();
	}
	
	public List searchUser()
	{
		List ls = new ArrayList();
		try {
			org.hibernate.Session session = sessionFactory.openSession();
			Query q = session.createQuery("from RegisterVO where status=true");
			ls = q.list();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
    }
	
	public List search(RegisterVO registerVO)
	{
		List ls = new ArrayList();
		try {
			org.hibernate.Session session = sessionFactory.openSession();
			Query q = session.createQuery("from RegisterVO where registerId='"+registerVO.getRegisterId()+"'");
			ls = q.list();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
    }

	

}
