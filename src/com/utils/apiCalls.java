package com.utils;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Repository

public class apiCalls {

	public String[] uploadToCloudinary(MultipartFile toUpload) throws Exception
	{
		String CLOUDINARY_URL="cloudinary://918193382451578:IM1wxFhxFxLwrO18j0BR5dFy54k@ducuxop9h";
		//String CLOUDINARY_URL="cloudinary://393864853192134:5TmBmhGm2Dw_yfRiKPROD2YVhvk@dnwmzxapc";  //try 2
		
		Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL); 
    //    File toUpload = new File(link);
         Map uploadResult = cloudinary.uploader().upload(toUpload.getBytes(),ObjectUtils.asMap("ocr", "adv_ocr"));
        System.out.println("uploadResult: "+uploadResult);
        System.out.println("uploadResult GET: "+uploadResult.get("secure_url"));
        /*System.out.println("uploadResult GETA1: "+uploadResult.get("textAnnotations"));*/
        Map ocrRes = (Map) uploadResult.get("info");
       /* System.out.println("ocrRes"+ocrRes);
        System.out.println("TA2"+ocrRes.get("textAnnotations"));*/
        
        String ss = uploadResult.toString();
    	String ss1[] = ss.split("textAnnotations");
    	String ss2[] = ss1[1].split("=");
    	
    	System.out.println(ss2[2]);
        
    	String ss3 = ss2[2].replaceAll("//s","");
    	String ss4 = ss3.replaceAll("//s","");
    	String ss5 = ss4.replaceAll(" ","");
    	String finalResult = ss5.replaceAll("IND","");
    	String lastCall = finalResult.replaceAll(",locale","");
        
    	 String[] returnResult = new String[2];
    	returnResult[0] = (String) uploadResult.get("secure_url");
    	returnResult[1] = lastCall;
    	
         return returnResult;
		
		
	}
	
	
}
