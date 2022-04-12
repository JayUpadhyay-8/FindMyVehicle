package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.TowDetailsDAO;
import com.vo.AreaVO;
import com.vo.RtoVO;
import com.vo.TowDetailsVO;

@Controller
public class TowDetailsController {
	@Autowired TowDetailsDAO towdetailsDAO;
	@RequestMapping(value = "viewDetails.html", method = RequestMethod.GET)
	public ModelAndView viewArea(@ModelAttribute TowDetailsVO towdetailsVO) {
		List towdetailsList = towdetailsDAO.viewDetails();
		
		return new ModelAndView("admin/viewTowDetails", "towdetailsList", towdetailsList);

	}

}
