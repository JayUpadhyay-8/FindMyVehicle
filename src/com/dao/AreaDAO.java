package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.AreaVO;

@Repository
public class AreaDAO {
	@Autowired 
	SessionFactory sessionfactory;
	
	public void insert(AreaVO areaVO)
	{
		try {
			Session session = sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(areaVO);
			transaction.commit();
			session.close();
			
			
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public List viewArea()
	{
		List areaList = new ArrayList<>();
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		Query q = session.createQuery("from AreaVO");
		areaList = q.list();
		

		
		trans.commit();
		session.close();
		
		return areaList;
	
	}
	public void deleteArea(AreaVO areaVO)
	{
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		session.delete(areaVO);
	
		trans.commit();
		session.close();
	}
	public List editArea(AreaVO areaVO)
	{
		
		List editList = new ArrayList<>();
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		Query q = session.createQuery("from AreaVO where id ="+areaVO.getId());
		editList = q.list();
		

		
		trans.commit();
		session.close();
		
		return editList;
	}



	
}
