package com.ryum.accountbook.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Controller
 * @author ryum
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
