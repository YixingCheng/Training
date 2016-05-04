package com.mercury.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.action.HelloAction;
import com.mercury.beans.User;
import com.mercury.beans.UserInfo;

@Path("/hello")
public class HelloResource {
	private HelloAction helloAction;
	
	public HelloResource(){
		if (helloAction==null) {
			ApplicationContext actx= new ClassPathXmlApplicationContext("config.xml");
			helloAction = (HelloAction) actx.getBean("helloAction");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserInfo getUserInfo(@FormParam("name") String name, @FormParam("age") int age){
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return helloAction.execute(user);
	}
	
	
	@GET
	@Path("{name}/{age}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserInfo getUserInfo2(@PathParam("name") String name, @PathParam("age") int age){
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return helloAction.execute(user);
	}
	
	
}
