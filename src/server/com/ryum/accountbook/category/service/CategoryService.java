package com.ryum.accountbook.category.service;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryum.accountbook.category.dto.Category;
import com.ryum.accountbook.category.repository.CategoryRepository;
import com.ryum.accountbook.common.enums.EnumUnit;
import com.ryum.accountbook.common.interfaces.DefaultCRUD;
import com.ryum.accountbook.config.enums.EnumConfig;
import com.ryum.accountbook.config.service.ConfigService;

/**
 * 카테고리 Service
 * @author ryum
 */
@Service
public class CategoryService implements DefaultCRUD<Category, Integer>, InitializingBean {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ConfigService configService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (configService.selectBoolean(EnumConfig.BOOLEAN_DEFAULT_CATEGORY_INSERT)) {
			defaultCategoryInsert();
			configService.insertBoolean(EnumConfig.BOOLEAN_DEFAULT_CATEGORY_INSERT, false);
		}
	}
	
	@Override
	public List<Category> selectAll() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Category insert(Category category) {
	  return categoryRepository.save(category);
	}
	
	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}
	
	@Override
	public void delete(Integer idx) {
		categoryRepository.deleteInBatch(categoryRepository.findByParentIdx(idx));
		categoryRepository.deleteById(idx);
	}
	
	/**
	 * 카테고리 기본값 추가
	 */
	public void defaultCategoryInsert() {
	  System.out.println("default category insert");
		Category earned = insert(new Category(EnumUnit.PLUS, "근로소득"));
		insert(new Category(EnumUnit.PLUS, "급여", earned.getIdx()));
		insert(new Category(EnumUnit.PLUS, "보너스", earned.getIdx()));
		
		Category financial = insert(new Category(EnumUnit.PLUS, "금융소득"));
		insert(new Category(EnumUnit.PLUS, "이자", financial.getIdx()));
		insert(new Category(EnumUnit.PLUS, "배당금", financial.getIdx()));
		
		Category food = insert(new Category(EnumUnit.MINUS, "식비"));
		insert(new Category(EnumUnit.MINUS, "식사", food.getIdx()));
		insert(new Category(EnumUnit.MINUS, "후식", food.getIdx()));
		insert(new Category(EnumUnit.MINUS, "군것질", food.getIdx()));
		
		Category transportation = insert(new Category(EnumUnit.MINUS, "교통비"));
		insert(new Category(EnumUnit.MINUS, "대중교통", transportation.getIdx()));
		insert(new Category(EnumUnit.MINUS, "택시", transportation.getIdx()));
		insert(new Category(EnumUnit.MINUS, "장거리경비", transportation.getIdx()));
		
		insert(new Category(EnumUnit.MINUS, "쇼핑비"));
		insert(new Category(EnumUnit.MINUS, "미용비"));
		
		Category car = insert(new Category(EnumUnit.MINUS, "차량유지비"));
		insert(new Category(EnumUnit.MINUS, "유류비", car.getIdx()));
		insert(new Category(EnumUnit.MINUS, "주차비", car.getIdx()));
		insert(new Category(EnumUnit.MINUS, "하이패스", car.getIdx()));
		insert(new Category(EnumUnit.MINUS, "정비/수리", car.getIdx()));
		
		Category home = insert(new Category(EnumUnit.MINUS, "주거생활비"));
		insert(new Category(EnumUnit.MINUS, "관리비", home.getIdx()));
		insert(new Category(EnumUnit.MINUS, "가스비", home.getIdx()));
		insert(new Category(EnumUnit.MINUS, "생활세금", home.getIdx()));
		
		insert(new Category(EnumUnit.MINUS, "문화생활비"));
		insert(new Category(EnumUnit.MINUS, "건강관리비"));
		
		Category social = insert(new Category(EnumUnit.MINUS, "사회생활비"));
		insert(new Category(EnumUnit.MINUS, "경조사비", social.getIdx()));
		
		Category financialOut = insert(new Category(EnumUnit.MINUS, "금융보험비"));
		insert(new Category(EnumUnit.MINUS, "수수료", financialOut.getIdx()));
		insert(new Category(EnumUnit.MINUS, "금융이자", financialOut.getIdx()));
		
		insert(new Category(EnumUnit.MINUS, "기타"));
	}
	
}
