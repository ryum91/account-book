package com.ryum.accountbook.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.account.dto.Account;
import com.ryum.accountbook.account.service.AccountService;
import com.ryum.accountbook.common.dto.Response;

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
	@GetMapping
	public ResponseEntity<?> selectAll() {
		return Response.ok().data(accountService.selectAll()).build();
	}
	
	/**
	 * 결제수단 추가
	 * @param account
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Account account) {
		return Response.created().data(accountService.insert(account)).build();
	}
	
	/**
	 * 결제수단 수정
	 * @param account
	 * @return
	 */
	@PutMapping(value = "/{idx}")
	public ResponseEntity<?> update(@PathVariable Integer idx, @RequestBody Account account) {
		account.setIdx(idx);
		return Response.ok().data(accountService.update(account)).build();
	}
	
	/**
	 * 결제수단 삭제
	 * @param idx
	 * @return
	 */
	@DeleteMapping(value = "/{idx}")
	public ResponseEntity<?> delete(@PathVariable Integer idx) {
		accountService.delete(idx);
		return Response.ok().build();
	}
}
