package com.ryum.accountbook.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.accountbook.category.dto.Category;
import com.ryum.accountbook.category.service.CategoryService;
import com.ryum.accountbook.common.dto.Response;

/**
 * 카테고리 Controller
 * 
 * @author ryum
 */
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	/**
	 * 카테고리 추가
	 * 
	 * @param category
	 * @return
	 */
//	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Category category) {
		return Response.created().data(categoryService.insert(category)).build();
	}

	/**
	 * 카테고리 수정
	 * 
	 * @param category
	 * @return
	 */
//	@PutMapping(value = "/{idx}")
	public ResponseEntity<?> update(@PathVariable Integer idx, @RequestBody Category category) {
		category.setIdx(idx);
		return Response.ok().data(categoryService.update(category)).build();
	}

	/**
	 * 카테고리 삭제
	 * 
	 * @param idx
	 * @return
	 */
//	@DeleteMapping(value = "/{idx}")
	public ResponseEntity<?> delete(@PathVariable Integer idx) {
		categoryService.delete(idx);
		return Response.ok().build();
	}

}
