package com.ryum.accountbook.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.common.exception.HttpStatusException;
import com.ryum.accountbook.history.dto.History;
import com.ryum.accountbook.history.service.HistoryService;

/**
 * 결제내역 Controller
 * @author ryum
 */
@RestController
@RequestMapping("/history")
public class HistoryController {

  @Autowired
  HistoryService historyService;
  
  /**
   * 전체 결제내역 목록 조회
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> selectAll() {
    return ResponseEntity.ok(historyService.selectAll());
  }
  
  /**
   * 결제내역 추가
   * @param history
   * @return
   * @throws Exception 
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> insert(@RequestBody(required = false) History history) throws HttpStatusException {
    if (null == history) {
      throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Request body is null");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(historyService.insert(history));
  }
  
  /**
   * 결제내역 수정
   * @param history
   * @return
   * @throws HttpStatusException
   */
  @RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
  public ResponseEntity<?> update(@PathVariable Integer idx, @RequestBody(required = false) History history) throws HttpStatusException {
    if (null == idx) {
      throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Idx is null");
    }
    if (null == history) {
      throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Request body is null");
    }
    history.setIdx(idx);
    return ResponseEntity.status(HttpStatus.OK).body(historyService.update(history));
  }
  
  /**
   * 결제내역 삭제
   * @param idx
   * @return
   * @throws HttpStatusException
   */
  @RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
  public ResponseEntity<?> delete(@PathVariable Integer idx) throws HttpStatusException {
    historyService.delete(idx);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
  
}
