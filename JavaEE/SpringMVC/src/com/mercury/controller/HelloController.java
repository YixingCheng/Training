package com.mercury.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.beans.User;

@Controller
public class HelloController {

	@Autowired
	private User user;
	@Value("http://localhost:8080/JSPDemo/hello.jsp")
	private String link;
	
	
	
	@RequestMapping("/hello")
	public ModelAndView sayHello(HttpServletRequest request){
		String name = request.getParameter("name");
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "Hello " + name + ", welcome to Spring MVC!");
		mav.setViewName("hello");
		return mav;
	}
	
	@RequestMapping("/main")
	public String goMain(ModelMap model){
		model.addAttribute("message", "Additional Information");
		return "main";
	}
	
	//@RequestMapping(value="/data", method=RequestMethod.POST)
	@RequestMapping("/data")
	@ResponseBody
	public String getData(){
		return "This is data, not a link";
	}
	
	@RequestMapping("/sso")
	public ModelAndView sso(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:" + link);
		mav.addObject("remotename", user.getName());
		mav.addObject("remoteage", user.getAge());
		return mav;
	}
}
