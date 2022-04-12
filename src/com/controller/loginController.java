package com.controller;


import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoginDAO;
import com.dao.RegisterDAO;
import com.vo.LoginVO;
import com.vo.RegisterVO;

@Controller
public class loginController {

	
	    @Autowired 
	    RegisterDAO registerDAO;
	    
	    @Autowired
	    LoginDAO loginDAO;
	    
	  
		@RequestMapping(value={"/","/login.html"},method=RequestMethod.GET)
		public ModelAndView homePage()
		{
			return new ModelAndView("login");
		}
	    
		/*
		@RequestMapping(value="login.html",method=RequestMethod.GET)
		public ModelAndView loginPage(){
			return new ModelAndView("login");
		}
		*/
		
		@RequestMapping(value="register.html",method=RequestMethod.GET)
		public ModelAndView register()
		{
			
			return new ModelAndView("register","RegisterVO",new RegisterVO());

		}
		
		@RequestMapping(value="registerins.html",method=RequestMethod.POST)
		public ModelAndView registerins(@ModelAttribute RegisterVO registerVO)
		{		registerDAO.insertRegister(registerVO);
	        	return new ModelAndView("redirect:/login.html");
	    }
		@RequestMapping(value="editRegister.html",method=RequestMethod.GET)
		public ModelAndView editRegister(@RequestParam("x") String x,@ModelAttribute LoginVO loginVO)
		{		
				
				loginVO.setUsername(x);
				List editList = loginDAO.searchstep1(loginVO);
				return new ModelAndView("user/updatePassword", "LoginVO", editList.get(0));

		}
		@RequestMapping(value="updatePassword.html",method=RequestMethod.POST)
		public ModelAndView updatePassword(@ModelAttribute LoginVO loginVO)
		{		
				
				
				loginDAO.updatePassword(loginVO);
				return new ModelAndView("login");

		}


		
		@RequestMapping(value="/admin.html",method=RequestMethod.GET)
		public ModelAndView adminindex(ModelMap model){
			
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNameA = user.getUsername();
			model.addAttribute("uname",userNameA);
			
			return new ModelAndView("admin/index");
		}
		
		
		@RequestMapping(value="/user.html",method=RequestMethod.GET)
		public ModelAndView userindex(ModelMap model){
			
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNameU = user.getUsername();
			//String Password = user.getPassword();
			model.addAttribute("uname",userNameU);
		
			
			return new ModelAndView("user/index");
			
		}
		
		
		@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
		public ModelAndView logout1(ModelMap model,HttpServletResponse response,HttpServletRequest request) 
		{
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		        if (auth != null) {
		            new SecurityContextLogoutHandler().logout(request, response, auth);
		            request.getSession().invalidate();
		            request.getSession().setAttribute("tempStatus", "success");
		            request.getSession().setAttribute("statusText", "Logout Successfully!");
		        }
		        return new ModelAndView("redirect:/");
			
		}
		
		
		
		
}
