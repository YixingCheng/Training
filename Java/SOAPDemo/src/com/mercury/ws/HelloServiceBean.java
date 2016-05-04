package com.mercury.ws;

import javax.jws.WebService;

@WebService(endpointInterface="com.mercury.ws.HelloService")
public class HelloServiceBean implements HelloService {

	@Override
	public String sayHello(String name){
		return "Hello " + name + ", welcome to Web Service (JAX-WS).";
	}
}
