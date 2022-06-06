package com.consulting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class ErrorController {

	@RequestMapping("/403")
	public ModelAndView Error403() {
		ModelAndView mv = new ModelAndView("error/403");
		return mv;
	}
	
	@RequestMapping("/404")
	public ModelAndView Error404() {
		ModelAndView mv = new ModelAndView("error/404");
		return mv;
	}
	
	@RequestMapping("/500")
	public ModelAndView Error500() {
		ModelAndView mv = new ModelAndView("error/500");
		return mv;
	}
}
