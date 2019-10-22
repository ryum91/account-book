package com.ryum.accountbook.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryum.accountbook.category.dto.Category;

/**
 * Category Repository
 * 
 * @author ryum
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByParentIdx(int parentIdx);

}
