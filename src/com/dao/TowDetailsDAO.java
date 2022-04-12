package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.TowDetailsVO;

@Repository
public class TowDetailsDAO {

	@Autowired SessionFactory sessionFactory;
	public void insertDetails(TowDetailsVO towdetailsVO){

	Session	session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	session.save(towdetailsVO);
	transaction.commit();
	session.close();
	
	}
	
	public List viewDetails()
	{
		List towdetailsList = new ArrayList<>();
		//SessionFactory s = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from TowDetailsVO");
		towdetailsList = q.list();
		transaction.commit();
		session.close();
		return towdetailsList;
	}
	
	
	
}
