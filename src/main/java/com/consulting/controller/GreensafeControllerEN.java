package com.consulting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.consulting.model.Email;
import com.consulting.service.NotificationService;

@RestController
@RequestMapping("/en")
public class GreensafeControllerEN {

	@Autowired
	NotificationService service;
	
	@RequestMapping
	public ModelAndView homePage() {
		return new ModelAndView("pages/en/index");
	}
	
	@RequestMapping("/services")
	public ModelAndView services() {
		return new ModelAndView("pages/en/services");
	}
	
	@RequestMapping("/about-us")
	public ModelAndView AboutUs() {
		return new ModelAndView("pages/en/about");
	}
	
	@RequestMapping("/carrer")
	public ModelAndView carrer() {
		return new ModelAndView("pages/en/carrer");
	}
	
	@RequestMapping("/contact-us")
	public ModelAndView contactUs(Email email) {
		return new ModelAndView("pages/en/contact");
	}
	
	@RequestMapping(value = "/contact-us", method = RequestMethod.POST)
	public ModelAndView sendEmail(@Validated Email email, BindingResult result, RedirectAttributes attributes) {
		
		String successMessage = "";
		String errorMessage = "";
		
		boolean isEmailSent = service.dispatchEmail(email);
		
		if (isEmailSent)
			successMessage = "Email sucessfully sent! Thank you, we will return as soon as possible...";
		else
			errorMessage = "Opps, the email wasn't sent! Sorry please try again later";
		
		attributes.addFlashAttribute("successMessage", successMessage);
		attributes.addFlashAttribute("errorMessage", errorMessage);
		
		return new ModelAndView("redirect:/en/contact-us");
	}
	
}
