package com.ryum.accountbook.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.category.dto.Category;
import com.ryum.accountbook.category.service.CategoryService;
import com.ryum.accountbook.common.exception.HttpStatusException;

/**
 * 카테고리 Controller
 * @author ryum
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	/**
	 * 전체 카테고리 목록 조회
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> selectAll() {
		return ResponseEntity.ok(categoryService.selectAll());
	}
	
	/**
	 * 카테고리 추가
	 * @param category
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody(required = false) Category category) throws HttpStatusException {
		if (null == category) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Request body is null");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.insert(category));
	}
	
	/**
	 * 카테고리 수정
	 * @param category
	 * @return
	 * @throws HttpStatusException
	 */
	@RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Integer idx, @RequestBody(required = false) Category category) throws HttpStatusException {
		if (null == idx) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Idx is null");
		}
		if (null == category) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Category is null");
		}
		category.setIdx(idx);
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(category));
	}
	
	/**
	 * 카테고리 삭제
	 * @param idx
	 * @return
	 * @throws HttpStatusException
	 */
	@RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer idx) throws HttpStatusException {
		categoryService.delete(idx);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}