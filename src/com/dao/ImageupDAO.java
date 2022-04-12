package com.dao;

import java.io.BufferedReader;  
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vo.AreaVO;

import com.vo.ImageupVO;
import com.vo.LocationVO;
import com.vo.RtoVO;
/*import com.vo.RtoVO;
import com.vo.TowDetailsVO;
*/
import com.vo.TowDetailsVO;

@Repository
public class ImageupDAO {
	@Autowired 
	SessionFactory sessionfactory;
	
	
	public void insertImage(ImageupVO imageupVO)
	{
		try {
			Session session = sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(imageupVO);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public String uploadcloudinary(String uploadlink) throws IOException
	{
		String CLOUDINARY_URL="cloudinary://292613566786751:Upxzzhyzboh7dkNRL6oxpPFdoBw@dgqn4brdb";
		//String CLOUDINARY_URL="cloudinary://393864853192134:5TmBmhGm2Dw_yfRiKPROD2YVhvk@dnwmzxapc";  //try 2
		Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL); 
        File toUpload = new File(uploadlink);
         Map uploadResult = cloudinary.uploader().upload(toUpload, ObjectUtils.emptyMap());
         System.out.println("uploadResult: "+uploadResult);
         System.out.println("uploadResult GET: "+uploadResult.get("secure_url"));
         return uploadResult.get("secure_url").toString();
		
		
	}
 
	public List getImageList(ImageupVO imageupvo)
	{
		List imageList = new ArrayList<>();
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		Query q = session.createQuery("from ImageupVO where id="+imageupvo.getId());
		imageList = q.list();
		

		
		trans.commit();
		session.close();
		
		return imageList;
	
	}
	public void updateImage(ImageupVO imageupVO)
	{
		try {
			Session session = sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.update(imageupVO);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}




}
	public void deleteImage(ImageupVO imageupVO)
	{
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		session.delete(imageupVO);
	
		trans.commit();
		session.close();
	}
	
	public void getMessageContact(ImageupVO imageupVO,RtoVO rtoVO,TowDetailsVO towdetailsVO)
	{
		List contactList = new ArrayList<>();
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		Query q = session.createQuery("from RtoVO where numPlate like '"+imageupVO.getOcrResult()+"'");
		contactList = q.list();
		Date date = new Date();
		Iterator it = contactList.iterator();
		while(it.hasNext())
		{
			rtoVO = (RtoVO)it.next();
			System.out.println(rtoVO.getOwnerEmail());
			System.out.println(rtoVO.getContactNumber());	
			towdetailsVO.setImageupvo(imageupVO);
			towdetailsVO.setRtoVO(rtoVO);
			towdetailsVO.setDate(date.toString());
		
		}
		
		
		
		
		trans.commit();
		session.close();
		
		
		
		
	}
	public void setAll(TowDetailsVO towdetailsVO,LocationVO locationVO,AreaVO areaVO)
	{
		List locationList = new ArrayList<>();
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		
		Query q = session.createQuery("from LocationVO where id = "+towdetailsVO.getImageupvo().getLocationVO().getId());
		locationList=q.list();
		Iterator it = locationList.iterator();
		while (it.hasNext())
		{
			 locationVO = (LocationVO) it.next(); 
			 System.out.println("aamchi"+locationVO.getLocation());
			 towdetailsVO.getImageupvo().getLocationVO().setLocation(locationVO.getLocation());
		}
		
		List areaList = new ArrayList<>();
		
		
		Query q1 = session.createQuery("from AreaVO where id = "+towdetailsVO.getImageupvo().getLocationVO().getAreaVO().getId());
		areaList=q1.list();
		Iterator it1 = areaList.iterator();
		while (it1.hasNext())
		{
			 areaVO = (AreaVO) it1.next(); 
			 System.out.println("aamchi"+areaVO.getAreaName());
			 towdetailsVO.getImageupvo().getLocationVO().getAreaVO().setAreaName(areaVO.getAreaName());
		}
		
		
		trans.commit();
		session.close();
		
		
		
		
	}
	
	
}