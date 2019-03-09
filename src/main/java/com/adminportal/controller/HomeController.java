package com.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Home controller.
 */
@Controller
public class HomeController {

	/**
	 * Index string.
	 *
	 * @return the string
	 */
	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}

	/**
	 * Home string.
	 *
	 * @return the string
	 */
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	/**
	 * Login string.
	 *
	 * @return the string
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
