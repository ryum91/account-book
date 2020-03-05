package com.ryum.accountbook.category.repository;

import com.ryum.accountbook.category.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Category Repository
 * 
 * @author ryum
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByParentIdx(int parentIdx);

}
