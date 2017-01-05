package com.pvmeira.hollos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("/menu")
	public ModelAndView newPatient() {
		ModelAndView mv = new ModelAndView("MenuInicial");
		return mv;
	}
}
