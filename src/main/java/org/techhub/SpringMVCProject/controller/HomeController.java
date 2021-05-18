package org.techhub.SpringMVCProject.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.techhub.SpringMVCProject.model.LoginModel;
import org.techhub.SpringMVCProject.model.Register;
import org.techhub.SpringMVCProject.service.RegisterService;

@Controller
public class HomeController {
	
	@Autowired
     RegisterService registerService;
	@RequestMapping(value="/")
	public String test(HttpServletResponse response) throws IOException{
		return  "home";
	}
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public String validateUser(LoginModel model,Map map)
	{
		 if(model.getName().equals("admin") && model.getPass().equals("admin"))
		 {
			 return "master";
		 }
		 else
		 {
			   map.put("msg","Invalid username and password");
		     return "home";//call master page here
		 }
	}
	@RequestMapping("/addnewrecord")  //this work as hyperlink or url in project
	public String addNewRecord()
	{
		return "addnewrecord";//call add new record .jsp from here 
	}
	@RequestMapping(value="/saverecord",method=RequestMethod.POST)
	public String saveRecord(Register register,Map map)
	{
		 boolean b=registerService.isRegister(register);
		 if(b)
		 {
			 map.put("msg","Record Save Success...........");
		 }
		 else
		 {
			  map.put("msg", "Some problem is there.............");
		 }
		return "addnewrecord";
	}
	
	@RequestMapping("/viewall")
	public String viewalldata(Map map)
	{
		List<Register> list=registerService.getAllRecords();
		 map.put("r", list);//r work as list on jsp page 
		return "viewalldata";
	}
}



























