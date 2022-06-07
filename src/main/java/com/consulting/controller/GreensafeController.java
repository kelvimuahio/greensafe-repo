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
@RequestMapping("/")
public class GreensafeController {

	@Autowired
	NotificationService service;
	
	@RequestMapping
	public ModelAndView homePage() {
		return new ModelAndView("pages/pt/index");
	}
	
	@RequestMapping("/servicos")
	public ModelAndView services() {
		return new ModelAndView("pages/pt/services");
	}
	
	@RequestMapping("/contacte-nos")
	public ModelAndView contacte(Email email) {
		return new ModelAndView("pages/pt/contact");
	}
	
	@RequestMapping(value = "/contacte-nos", method = RequestMethod.POST)
	public ModelAndView sendEmail(@Validated Email email, BindingResult result, RedirectAttributes attributes) {
		
		attributes.addFlashAttribute("message", 
				service.dispatchEmail(email) ? 
						"E-mail enviado com sucesso! Obrigado, retornaremos assim que possível."
						: "Opps, não foi possível enviar o email! Perdão, por favor tente de novo.");
		
		return new ModelAndView("redirect:/contacte-nos");
	}
}
