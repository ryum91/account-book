package com.ryum.accountbook.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ryum.accountbook.account.dto.Account;
import com.ryum.accountbook.account.repository.AccountRepository;
import com.ryum.accountbook.common.exception.HttpStatusException;
import com.ryum.accountbook.common.interfaces.DefaultCRUD;

/**
 * 결제수단 Service
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
	public Account insert(Account account) throws HttpStatusException {
		try {
			if (0 != account.getIdx()) {
				throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Index is not null");
			}
			return accountRepository.save(account);
		} catch (DataIntegrityViolationException e) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, e);
		}
	}

	@Override
	public Account update(Account account) throws HttpStatusException {
		if (!isExist(account.getIdx())) {
			throw new HttpStatusException(HttpStatus.NOT_FOUND, "Index " + account.getIdx() + " could not be found");
		}
		return accountRepository.save(account);
	}

	@Override
	public void delete(Integer idx) throws HttpStatusException {
		if (null == idx) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Idx is null");
		}
		if (!isExist(idx)) {
			throw new HttpStatusException(HttpStatus.NOT_FOUND, "Index " + idx + " could not be found");
		}
		accountRepository.deleteById(idx);
	}
	
	/**
	 * 인덱스 존재 여부 반환
	 * @param idx
	 * @return
	 */
	private boolean isExist(Integer idx) {
		return null != accountRepository.findById(idx).orElse(null);
	}
	
}
