package com.ryum.accountbook.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Controller
 * 
 * @author ryum
 */
@Controller
public class PageController implements ErrorController {

	@GetMapping("/")
	public String index() {
		return "/dist/index.html";
	}

	@RequestMapping("/error")
	public String error() {
		return "/dist/index.html";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
