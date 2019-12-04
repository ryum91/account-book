package com.ryum.accountbook.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.common.dto.Response;
import com.ryum.accountbook.history.dto.History;
import com.ryum.accountbook.history.service.HistoryService;

/**
 * 결제내역 Controller
 * 
 * @author ryum
 */
@CrossOrigin
@RestController
@RequestMapping("/api/history")
public class HistoryController {

	@Autowired
	HistoryService historyService;

	/**
	 * 전체 결제내역 목록 조회
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> selectAll() {
		return Response.ok().data(historyService.selectAll()).build();
	}

	/**
	 * 결제내역 추가
	 * 
	 * @param history
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody History history) {
		return Response.created().data(historyService.insert(history)).build();
	}

	/**
	 * 결제내역 수정
	 * 
	 * @param history
	 * @return
	 */
	@PutMapping(value = "/{idx}")
	public ResponseEntity<?> update(@PathVariable Integer idx, @RequestBody History history) {
		history.setIdx(idx);
		return Response.ok().data(historyService.update(history)).build();
	}

	/**
	 * 결제내역 삭제
	 * 
	 * @param idx
	 * @return
	 */
	@DeleteMapping(value = "/{idx}")
	public ResponseEntity<?> delete(@PathVariable Integer idx) {
		historyService.delete(idx);
		return Response.ok().build();
	}

}
