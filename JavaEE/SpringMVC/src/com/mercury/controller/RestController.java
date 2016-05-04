package com.mercury.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.beans.Person;

@Controller
public class RestController {
	@Resource
	private List<Person> personList;
	
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	@ResponseBody
	public Person getPerson(){
		Person person = new Person();
		person.setFirstName("Cindy");
		person.setLastName("Yuan");
		return person;
	}
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	@ResponseBody
	public List<Person> getPersonList() {
		return personList;
	}
}
