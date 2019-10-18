package com.ryum.accountbook.category.service;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ryum.accountbook.category.dto.Category;
import com.ryum.accountbook.category.repository.CategoryRepository;
import com.ryum.accountbook.common.enums.EnumUnit;
import com.ryum.accountbook.common.exception.HttpStatusException;
import com.ryum.accountbook.config.enums.EnumConfig;
import com.ryum.accountbook.config.service.ConfigService;

/**
 * 카테고리 Service
 * @author ryum
 */
@Service
public class CategoryService implements InitializingBean {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ConfigService configService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (configService.selectBoolean(EnumConfig.BOOLEAN_INIT_CATEGORY_INSERT)) {
			initCategoryInsert();
			configService.insertBoolean(EnumConfig.BOOLEAN_INIT_CATEGORY_INSERT, false);
		}
	}
	
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
	 * 카테고리 수정
	 * @param category
	 * @throws HttpStatusException
	 */
	public Category update(Category category) throws HttpStatusException {
		if (!isExist(category.getIdx())) {
			throw new HttpStatusException(HttpStatus.NOT_FOUND, "Index " + category.getIdx() + " could not be found");
		}
		if (0 != category.getParentIdx() && !isExist(category.getParentIdx())) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Parent index " + category.getParentIdx() + " could not be found");
		}
		if (category.getParentIdx() == category.getIdx()) {
			throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Parent index and category index cannot be the same.");
		}
		return categoryRepository.save(category);
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

	/**
	 * 카테고리 초기값 추가
	 */
	private void initCategoryInsert() {
		Category earned = insert(new Category(EnumUnit.PLUS, "근로소득"));
		insert(new Category(EnumUnit.PLUS, "급여", earned.getIdx()));
		insert(new Category(EnumUnit.PLUS, "보너스", earned.getIdx()));
		
		Category financial = insert(new Category(EnumUnit.PLUS, "금융소득"));
		insert(new Category(EnumUnit.PLUS, "이자", financial.getIdx()));
		insert(new Category(EnumUnit.PLUS, "배당금", financial.getIdx()));
		
		insert(new Category(EnumUnit.MINUS, "식비"));
		insert(new Category(EnumUnit.MINUS, "교통비"));
		insert(new Category(EnumUnit.MINUS, "쇼핑비"));
		insert(new Category(EnumUnit.MINUS, "미용비"));
		insert(new Category(EnumUnit.MINUS, "차량유지비"));
		insert(new Category(EnumUnit.MINUS, "주거생활비"));
		insert(new Category(EnumUnit.MINUS, "문화생활비"));
		insert(new Category(EnumUnit.MINUS, "건강관리비"));
		insert(new Category(EnumUnit.MINUS, "사회생활비"));
		insert(new Category(EnumUnit.MINUS, "금융보험비"));
		insert(new Category(EnumUnit.MINUS, "기타"));
	}
	
}
