package com.mercury.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mercury.beans.Person;

@Path("/hello")
public class HelloResource {
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person getPerson(){
		Person person = new Person();
		person.setFirstName("Mary");
		person.setLastName("Wang");
		person.setAge(50);
		return person;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person getPerson2(){
		Person person = new Person();
		person.setFirstName("Steven");
		person.setLastName("Zhang");
		person.setAge(50);
		return person;
	}
}
