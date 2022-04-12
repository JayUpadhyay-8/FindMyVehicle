package com.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import javax.mail.MessagingException;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.ImageupDAO;
import com.dao.LocationDAO;
import com.dao.TowDetailsDAO;
/*import com.dao.TowDetailsDAO;*/
import com.dao.AreaDAO;
import com.vo.AreaVO;

import com.vo.ImageupVO;
import com.vo.LocationVO;
import com.vo.RtoVO;
import com.vo.TowDetailsVO;
/*import com.vo.RtoVO;
import com.vo.TowDetailsVO;
*/import com.utils.*;

@Controller
public class ImageController {
	
	@Autowired
	AreaDAO areaDAO;
	@Autowired
	ImageupDAO imageupDAO;
	@Autowired
	LocationDAO locationDAO;
	@Autowired 
	apiCalls apicalls;
	@Autowired
	TowDetailsDAO towdetailsDAO;
	@Autowired 
	testEmail testEmail;

	/*
	 * @RequestMapping(value="editImage.html",method=RequestMethod.GET) public
	 * ModelAndView editImage(@RequestParam ("id") String id,@ModelAttribute
	 * ImageVO imageVO) { imageVO.setId(Integer.parseInt(id)); List
	 * editList=imageDAO.editImage(imageVO); return new
	 * ModelAndView("admin/addImage","ImageVO",editList.get(0));
	 * 
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "addImageUserUpload.html", method = RequestMethod.GET)
	public ModelAndView addImageUser() {
		List locationList = locationDAO.search();
		List areaList = areaDAO.viewArea();

		
		return new ModelAndView("user/addImageUser", "locationList", locationList)
				.addObject("ImageupVO", new ImageupVO()).addObject("areaList", areaList);

	}
	@RequestMapping(value="addImageCloud.html",method= RequestMethod.POST)
	public ModelAndView addImageCloud(@RequestParam(value = "file") MultipartFile files,
			@ModelAttribute ImageupVO imageupVO){
		//String finalpath = "D:/final/fmv-host-aws/WebContent/numberplateimages";
		String filename = files.getOriginalFilename();
		//String pathOnline = finalpath + "/" + filename;
		String returnResult[]=null;
		try {
			returnResult = apicalls.uploadToCloudinary(files);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	try {
			byte barr[] = files.getBytes();

		 imageVO.setImageBytes(barr); 
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(pathOnline));
		bout.write(barr);
		bout.flush();
		bout.close();
		
		 returnResult = apicalls.uploadToCloudinary(pathOnline);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		//System.out.println("Cloud Lenk "+cloudLink);

		imageupVO.setFilename(filename);
		imageupVO.setFilepath(returnResult[0]);
		imageupVO.setOcrResult(returnResult[1]);
		imageupDAO.insertImage(imageupVO);
		
		List imageList = imageupDAO.getImageList(imageupVO);
		
		
		return new ModelAndView("user/ocrVerify", "ImageupVO", imageList.get(0));
		
		/*File compressit = new File(pathonline);*/
	}
	


	@RequestMapping(value = "updateOcrResult.html", method = RequestMethod.POST)
	public ModelAndView updateOcr(@ModelAttribute ImageupVO imageupVO,@ModelAttribute RtoVO rtoVO,@ModelAttribute TowDetailsVO towdetailsVO,@ModelAttribute LocationVO locationVO,@ModelAttribute AreaVO areaVO) throws Exception {
		System.out.println(imageupVO.getFilename());
		
		imageupDAO.insertImage(imageupVO);
		imageupDAO.getMessageContact(imageupVO, rtoVO,towdetailsVO);
		towdetailsDAO.insertDetails(towdetailsVO);
		imageupDAO.setAll(towdetailsVO,locationVO,areaVO);
		try {
			testEmail.sendHtmlEmail(towdetailsVO);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/addImageUserUpload.html");
	}

	
	@RequestMapping(value = "deleteImage.html", method = RequestMethod.GET)
	public ModelAndView deleteImage(@RequestParam("id") String id, @ModelAttribute ImageupVO imageupVO) {
		imageupVO.setId(Integer.parseInt(id));
		imageupDAO.deleteImage(imageupVO);
		return new ModelAndView("redirect:/ViewImage.html");

	}

}
