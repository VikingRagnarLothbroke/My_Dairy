package com.twg.spring1.controllers;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twg.spring1.Business.EntryBusinessInterface;
import com.twg.spring1.Business.UserBusinessInterface;
import com.twg.spring1.Entities.Entry;
import com.twg.spring1.Entities.User;

import jakarta.servlet.http.HttpSession;

@Controller

public class Homecontrollers {
	
	
	public Date userentrydate;
	@Autowired
	private UserBusinessInterface userBusinessInterface;
	
	@Autowired
	private EntryBusinessInterface  entryBusinessInterface;

	
	//Session Creation
	@Autowired
     HttpSession session;
	
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@RequestMapping("/home")
	public ModelAndView HomePageMethod(Model m) {
		  
		ModelAndView model = new ModelAndView();
	    model.setViewName("home"); 
	    m.addAttribute("name","Mahesh");
		
		return model;	
	}
	
	@RequestMapping("/register")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		return model;	
	}
	@RequestMapping("/login")
	public ModelAndView log() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;		
	}
	
	//Registration Method
	
	@RequestMapping(path="/createuser",method=RequestMethod.POST)
	public String usercreation(@RequestParam("name")  String str, @RequestParam("password") String str1) {
		
		User user=new User();
		//user.setId(0);
		user.setName(str);
		user.setPassword(str1);
		userBusinessInterface.save(user);
		return "login";	
	}
	
	//Login Logic
	
	@RequestMapping(path="/homepage",method=RequestMethod.POST)
	public ModelAndView homepage(@RequestParam("name")  String str, @RequestParam("password") String str1) {
		
		ModelAndView model=new ModelAndView();
		User user=new User();
		//user.setId(0);
		user.setName(str);
		user.setPassword(str1);
	User user1=userBusinessInterface.findByname(user.getName());
	System.out.println(user.getPassword());
	System.out.println(user1.getPassword());
	if(user1 !=null && user.getName().equals(user1.getName())) {
		model.setViewName("Mydairyhomepage");
		session.setAttribute("user", user1);
	}
	 return model;
}
	
	@RequestMapping("/success")
	public String successful() {
		return "success";
	}
	
	//AddEntry Method
	
	@RequestMapping(path="/addentry",method=RequestMethod.POST)
	public String addentryindairy(@ModelAttribute("entry") Entry entry) {
		
	
	User user=(User)session.getAttribute("user");
	
	entry.setUserid(user.getId());
	
	entryBusinessInterface.save(entry);
		
		return "Mydairyhomepage";
	}
	
	//SignOut Method
	
	@RequestMapping("/signout")
	public String signoutfromdairy() {
		return null;
	}
	
	//View Method
	
	@RequestMapping("/view")
	public String dairyentryView() {
		
		
		return "Userentry";
	}
	
	//Update Method
	
	@RequestMapping("/update")
	public String dairyentryUpdate() {
		return null;
	}
	
	//Delete Method
	
	@RequestMapping("/delete")
	public String dairyentryDelete() {
		return null;
	}
	
}
