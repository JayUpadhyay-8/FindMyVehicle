package com.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AreaDAO;
import com.dao.LocationDAO;
import com.vo.*;
import com.dao.*;


@Controller
public class LocationController {
	@Autowired
	LocationDAO locdao;
	
	@Autowired
	AreaDAO areadao;
	
	@RequestMapping(value = "loadLocation.html", method = RequestMethod.GET)
	public ModelAndView Load()
	{
		List areaList = areadao.viewArea();
		return new ModelAndView("admin/Addlocation","areaList",areaList).addObject("LocationVO", new LocationVO());

	}
	
	@RequestMapping(value = "insertLocation.html", method = RequestMethod.POST)
	public ModelAndView insertLocation(@ModelAttribute LocationVO locvo)
	{
		locvo.setStatus(1);
		locdao.insert(locvo);
		return new ModelAndView("redirect:searchLocation.html");
	}
	
	@RequestMapping(value="searchLocation.html", method=RequestMethod.GET)
	public ModelAndView Search(Model m)
	{
		List Locationlist = new ArrayList<>();  
		Locationlist = locdao.search();
		m.addAttribute("Locationls",Locationlist);
		return new ModelAndView("admin/Viewlocation","LocationVO",m);
	}
	
	@RequestMapping(value = "deleteLocation.html", method = RequestMethod.GET)
	public ModelAndView deleteLocation(@RequestParam ("id") String id,@ModelAttribute LocationVO locvo)
	{
		locvo.setId(Integer.parseInt(id));
		locvo.setStatus(0);
		locdao.insert(locvo);
		return new ModelAndView("redirect:searchLocation.html");
	}
	
	@RequestMapping(value = "editlocation.html", method = RequestMethod.GET)
	public ModelAndView Edit(@RequestParam ("id") String id, @ModelAttribute LocationVO locvo) {
		locvo.setId(Integer.parseInt(id));
		List list = new ArrayList<>();
		list = locdao.edit(locvo);
		List areaList = areadao.viewArea();
		return new ModelAndView("admin/Addlocation","LocationVO",(LocationVO)list.get(0)).addObject("areaList",areaList);
	}
}