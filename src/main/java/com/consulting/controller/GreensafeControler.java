package com.consulting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/")
public class GreensafeControler {

	@RequestMapping
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("pages/home");
		return mv;
	}
	
}
