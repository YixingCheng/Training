package com.mercury.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.service.HelloService;

public final class HelloAction {
	
	@Autowired
	private HelloService hs;
	
	public UserInfo execute(User user){
		return hs.process(user);
	}
	
}
