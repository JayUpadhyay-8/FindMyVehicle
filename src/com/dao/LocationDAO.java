package com.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.*;
import com.dao.ImageupDAO;

@Repository
public class LocationDAO {

	@Autowired
	SessionFactory sessionFactory;
	public void insert(LocationVO locvo) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(locvo);
			transaction.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public List search()
	{
		List ls = new ArrayList<>();
		//SessionFactory s = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sess = sessionFactory.openSession();
		Transaction t = sess.beginTransaction();
		
		Query q = sess.createQuery("from LocationVO where status = "+1);
		ls = q.list();
		t.commit();
		sess.close();
		return ls;
	}
	
	public void delete(LocationVO locVO)
	{
		//locVO.setStatus(0);
	
		
	/*	Session szess = sessionFactory.openSession();
		Transaction t = sess.beginTransaction();

		sess.delete(locVO);
		t.commit();
		sess.close();
*/	}
	
	public List edit(LocationVO locvo)
	{
		List ls = new ArrayList<>();
		//SessionFactory s = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sess = sessionFactory.openSession();
		Transaction t = sess.beginTransaction();
		
		Query q = sess.createQuery("from LocationVO where id ="+locvo.getId()+"");
		ls = q.list();
		t.commit();
		sess.close();
		return ls;	
	}

}