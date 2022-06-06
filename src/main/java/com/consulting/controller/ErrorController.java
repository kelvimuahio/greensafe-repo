package com.consulting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class ErrorController {

	@RequestMapping("/404")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("error/404");
		return mv;
	}
	
}
