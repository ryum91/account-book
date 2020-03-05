package com.ryum.accountbook.history.controller;

import com.ryum.accountbook.common.dto.Response;
import com.ryum.accountbook.history.dto.History;
import com.ryum.accountbook.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 결제내역 Controller
 * 
 * @author ryum
 */
@RestController
public class HistoryController {

	@Autowired
	HistoryService historyService;

	/**
	 * 결제내역 추가
	 * 
	 * @param history
	 * @return
	 */
//	@PostMapping
	public ResponseEntity<?> insert(@RequestBody History history) {
		return Response.created().data(historyService.insert(history)).build();
	}

	/**
	 * 결제내역 수정
	 * 
	 * @param history
	 * @return
	 */
//	@PutMapping(value = "/{idx}")
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
//	@DeleteMapping(value = "/{idx}")
	public ResponseEntity<?> delete(@PathVariable Integer idx) {
		historyService.delete(idx);
		return Response.ok().build();
	}

}
