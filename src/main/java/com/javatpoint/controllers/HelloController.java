package com.javatpoint.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.dao.UsersDao;
import com.javatpoint.models.Users;

@Controller
public class HelloController {
	
	UsersDao udao;

	@RequestMapping("/hello")
	public String display(Model m){
		m.addAttribute("command", new Users());
		return "viewspage";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView savedata(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("users") Users users) {
		udao.save(users);
		return new ModelAndView("result", "firstname", users.getName());
	}

}
