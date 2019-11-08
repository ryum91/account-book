package com.ryum.accountbook.common.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Controller
 * 
 * @author ryum
 */
@Controller
public class PageController implements ErrorController {

	@RequestMapping(value = {"/", "/error"})
	public String index(HttpServletResponse res) {
		res.setStatus(HttpStatus.OK.value());
		return "/dist/index.html";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
