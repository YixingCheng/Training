package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.beans.User;
import com.mercury.service.HelloService;

@Controller
public class HelloController {
	@Autowired
	private HelloService hs;
	@Value("result")
	private String viewPage;
	
	@RequestMapping("/main")
	public String goMain(){
		return "hello";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo", hs.process(user));
		mav.setViewName(viewPage);
		return mav;
	}
	
}
