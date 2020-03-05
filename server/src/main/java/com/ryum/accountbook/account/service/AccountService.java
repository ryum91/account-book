package com.ryum.accountbook.account.service;

import com.ryum.accountbook.account.dto.Account;
import com.ryum.accountbook.account.repository.AccountRepository;
import com.ryum.accountbook.common.interfaces.DefaultCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 결제수단 Service
 * 
 * @author ryum
 */
@Service
public class AccountService implements DefaultCRUD<Account, Integer> {

	@Autowired
    AccountRepository accountRepository;

	@Override
	public List<Account> selectAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account insert(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account update(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void delete(Integer idx) {
		accountRepository.deleteById(idx);
	}

}
