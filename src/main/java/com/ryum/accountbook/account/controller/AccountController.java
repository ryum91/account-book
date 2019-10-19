package com.ryum.accountbook.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.account.dto.Account;
import com.ryum.accountbook.account.service.AccountService;
import com.ryum.accountbook.common.exception.HttpStatusException;

/**
 * 결제수단 Controller
 * @author ryum
 */
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	/**
	 * 전체 결제수단 목록 조회
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> selectAll() {
		return ResponseEntity.ok(accountService.selectAll());
	}
	
	/**
	 * 결제수단 추가
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody(required = false) Account account) throws HttpStatusException {
		if (null == account) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Request body is null");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.insert(account));
	}
	
	/**
	 * 결제수단 수정
	 * @param account
	 * @return
	 * @throws HttpStatusException
	 */
	@RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Integer idx, @RequestBody(required = false) Account account) throws HttpStatusException {
		if (null == idx) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Idx is null");
		}
		if (null == account) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "account is null");
		}
		account.setIdx(idx);
		return ResponseEntity.status(HttpStatus.OK).body(accountService.update(account));
	}
	
	/**
	 * 결제수단 삭제
	 * @param idx
	 * @return
	 * @throws HttpStatusException
	 */
	@RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer idx) throws HttpStatusException {
		accountService.delete(idx);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
