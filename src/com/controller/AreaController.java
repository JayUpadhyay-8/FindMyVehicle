package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vo.AreaVO;
import com.dao.AreaDAO;



@Controller
public class AreaController {

	

	@Autowired
	AreaDAO areaDAO;
	
	
	@RequestMapping(value="indexUser.html",method = RequestMethod.GET)
	public ModelAndView loadIndexUser(){
		return new ModelAndView("user/index");
	}

	
	
	@RequestMapping(value = "addArea.html", method = RequestMethod.GET)
	public ModelAndView addarea() {
		return new ModelAndView("admin/AddArea", "AreaVO", new AreaVO());

	}
	@RequestMapping(value = "insertArea.html", method = RequestMethod.POST)
	public ModelAndView insertArea(@ModelAttribute AreaVO areaVO) {
		areaDAO.insert(areaVO);
		return new ModelAndView("redirect:/addArea.html");

	}
	@RequestMapping(value = "viewArea.html", method = RequestMethod.GET)
	public ModelAndView viewArea(@ModelAttribute AreaVO areaVO) {
		List areaList = areaDAO.viewArea();
		return new ModelAndView("admin/ViewArea", "areaList", areaList);

	}

	@RequestMapping(value = "deleteArea.html", method = RequestMethod.GET)
	public ModelAndView deleteArea(@RequestParam("id") String id, @ModelAttribute AreaVO areaVO) {
		areaVO.setId(Integer.parseInt(id));
		areaDAO.deleteArea(areaVO);
		return new ModelAndView("redirect:/viewArea.html");

	}

	@RequestMapping(value = "editArea.html", method = RequestMethod.GET)
	public ModelAndView editArea(@RequestParam("id") String id, @ModelAttribute AreaVO areaVO) {
		areaVO.setId(Integer.parseInt(id));
		List editList = areaDAO.editArea(areaVO);
		return new ModelAndView("admin/AddArea", "AreaVO", editList.get(0));

	}



}
