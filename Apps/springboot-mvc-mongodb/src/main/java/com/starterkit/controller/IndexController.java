package com.starterkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ismailibrahim.s@cognizant.com requestmapping
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	String index() {
		return "index";
	}
}
