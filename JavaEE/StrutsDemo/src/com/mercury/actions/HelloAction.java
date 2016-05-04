package com.mercury.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mercury.beans.User;
import com.mercury.service.HelloService;

public class HelloAction extends Action{
	
	private HelloService hs;
	
	public HelloAction(){
		if (hs == null) hs = new HelloService();
	}

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		User user = (User) form;
		request.setAttribute("userInfo", hs.process(user));
		return mapping.findForward("result");
	}
	
	public HelloService getHs() {
		return hs;
	}

	public void setHs(HelloService hs) {
		this.hs = hs;
	}

	
}
