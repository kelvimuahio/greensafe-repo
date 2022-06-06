package com.consulting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/en")
public class GreensafeControlerEN {

	@RequestMapping
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("pages/home_en");
		return mv;
	}
	
	
}
