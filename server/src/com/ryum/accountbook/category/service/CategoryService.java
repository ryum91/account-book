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
 * 
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
		Category earned = insert(new Category(EnumUnit.PLUS, "근로소득", "mdi-briefcase-account-outline"));
		insert(new Category(EnumUnit.PLUS, "급여", "mdi-briefcase-account-outline", earned.getIdx()));
		insert(new Category(EnumUnit.PLUS, "보너스", "mdi-briefcase-account-outline", earned.getIdx()));

		Category financial = insert(new Category(EnumUnit.PLUS, "금융소득", "mdi-bank"));
		insert(new Category(EnumUnit.PLUS, "이자", "mdi-bank", financial.getIdx()));
		insert(new Category(EnumUnit.PLUS, "배당금", "mdi-bank", financial.getIdx()));

		Category food = insert(new Category(EnumUnit.MINUS, "식비", "mdi-silverware-fork-knife"));
		insert(new Category(EnumUnit.MINUS, "식사", "mdi-silverware-fork-knife", food.getIdx()));
		insert(new Category(EnumUnit.MINUS, "후식", "mdi-coffee", food.getIdx()));
		insert(new Category(EnumUnit.MINUS, "군것질", "mdi-bread-slice", food.getIdx()));

		Category transportation = insert(new Category(EnumUnit.MINUS, "교통비", "mdi-bus"));
		insert(new Category(EnumUnit.MINUS, "대중교통", "mdi-bus", transportation.getIdx()));
		insert(new Category(EnumUnit.MINUS, "택시", "mdi-taxi", transportation.getIdx()));
		insert(new Category(EnumUnit.MINUS, "장거리경비", "mdi-train-variant", transportation.getIdx()));

		insert(new Category(EnumUnit.MINUS, "쇼핑비", "mdi-shopping"));
		insert(new Category(EnumUnit.MINUS, "미용비", "mdi-content-cut"));

		Category car = insert(new Category(EnumUnit.MINUS, "차량유지비", "mdi-car"));
		insert(new Category(EnumUnit.MINUS, "유류비", "mdi-oil", car.getIdx()));
		insert(new Category(EnumUnit.MINUS, "주차비", "mdi-parking", car.getIdx()));
		insert(new Category(EnumUnit.MINUS, "하이패스", "mdi-highway", car.getIdx()));
		insert(new Category(EnumUnit.MINUS, "정비/수리", "mdi-wrench", car.getIdx()));

		Category home = insert(new Category(EnumUnit.MINUS, "주거생활비", "mdi-home"));
		insert(new Category(EnumUnit.MINUS, "관리비", "mdi-shield-account", home.getIdx()));
		insert(new Category(EnumUnit.MINUS, "가스비", "mdi-fuel", home.getIdx()));
		insert(new Category(EnumUnit.MINUS, "생활세금", "mdi-cash-usd", home.getIdx()));

		insert(new Category(EnumUnit.MINUS, "문화생활비", "mdi-movie-open"));
		insert(new Category(EnumUnit.MINUS, "건강관리비", "mdi-hospital-box"));

		Category social = insert(new Category(EnumUnit.MINUS, "사회생활비", "mdi-home-group"));
		insert(new Category(EnumUnit.MINUS, "경조사비", "mdi-account-group", social.getIdx()));

		Category financialOut = insert(new Category(EnumUnit.MINUS, "금융보험비", "mdi-bank"));
		insert(new Category(EnumUnit.MINUS, "수수료", "mdi-bank", financialOut.getIdx()));
		insert(new Category(EnumUnit.MINUS, "금융이자", "mdi-bank", financialOut.getIdx()));

		insert(new Category(EnumUnit.MINUS, "기타", "mdi-dots-horizontal-circle"));
	}

}
