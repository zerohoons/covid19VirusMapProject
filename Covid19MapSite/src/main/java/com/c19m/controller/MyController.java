package com.c19m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.c19m.service.MyService;

@Controller
public class MyController {

	@Autowired
	private MyService myService;
	
	@RequestMapping("insert.do")
	public ModelAndView insertCommand() {
		return new ModelAndView("mainPage");
	}
}
