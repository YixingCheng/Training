package com.mercury.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService hs;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody
	public UserInfo execute(HttpServletRequest request){
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		return hs.process(user);
	}
	
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	@ResponseBody
	public UserInfo execute2(HttpServletRequest request){
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		return hs.process(user);
	}
	
}
