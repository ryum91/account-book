package com.ryum.accountbook.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Page Controller
 * 
 * @author ryum
 */
@Controller
public class PageController {

	@GetMapping("/")
	public String index() {
		return "/public/index.html";
	}

}
