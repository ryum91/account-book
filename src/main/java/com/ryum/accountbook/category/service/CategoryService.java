package com.ryum.accountbook.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ryum.accountbook.category.dto.Category;
import com.ryum.accountbook.category.repository.CategoryRepository;
import com.ryum.accountbook.common.exception.HttpStatusException;

/**
 * Category Service
 * @author ryum
 */
@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	/**
	 * 전체 목록 조회
	 * @return
	 */
	public List<Category> selectAll() {
		return categoryRepository.findAll();
	}
	
	/**
	 * 추가
	 * @param category
	 * @return
	 * @throws Exception 
	 */
	public Category insert(Category category) throws HttpStatusException {
		try {
			return categoryRepository.save(category);
			
		} catch (DataIntegrityViolationException e) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, e);
		}
	}
}
