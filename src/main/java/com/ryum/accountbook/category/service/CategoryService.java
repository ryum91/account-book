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
 * 카테고리 Service
 * @author ryum
 */
@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	/**
	 * 카테고리 전체 목록 조회
	 * @return
	 */
	public List<Category> selectAll() {
		return categoryRepository.findAll();
	}
	
	/**
	 * 카테고리 추가
	 * @param category
	 * @return
	 * @throws Exception 
	 */
	public Category insert(Category category) throws HttpStatusException {
		try {
			if (0 != category.getParentIdx() && !isExist(category.getParentIdx())) {
				throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Parent index " + category.getParentIdx() + " could not be found");
			}
			return categoryRepository.save(category);
		} catch (DataIntegrityViolationException e) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, e);
		}
	}
	
	/**
	 * 카테고리 삭제
	 * @param category
	 * @throws HttpStatusException
	 */
	public void delete(int idx) throws HttpStatusException {
		if (!isExist(idx)) {
			throw new HttpStatusException(HttpStatus.NOT_FOUND, "Index " + idx + " could not be found");
		}
		categoryRepository.deleteInBatch(categoryRepository.findByParentIdx(idx));
		categoryRepository.deleteById(idx);
	}
	
	/**
	 * 카테고리 존재 여부 반환
	 * @param idx
	 * @return
	 */
	private boolean isExist(Integer idx) {
		return null != categoryRepository.findById(idx).orElse(null);
	}
}
