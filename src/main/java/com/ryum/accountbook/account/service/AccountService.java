package com.ryum.accountbook.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryum.accountbook.account.repository.AccountRepository;

/**
 * 결제 수단 Service
 * @author ryum
 */
@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
}
