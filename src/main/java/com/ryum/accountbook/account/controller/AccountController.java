package com.ryum.accountbook.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.account.service.AccountService;

/**
 * 결제 수단 Controller
 * @author ryum
 */
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
}
