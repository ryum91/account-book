package com.ryum.accountbook.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	 * 조회
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> selectAll() {
		return ResponseEntity.ok(categoryService.selectAll());
	}
	
	/**
	 * 추가
	 * @param category
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Category category) throws HttpStatusException {
		return ResponseEntity.ok(categoryService.insert(category));
	}
	
}
