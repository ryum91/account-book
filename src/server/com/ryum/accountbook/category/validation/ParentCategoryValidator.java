package com.ryum.accountbook.category.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ryum.accountbook.category.repository.CategoryRepository;

@Component
public class ParentCategoryValidator implements ConstraintValidator<ParentCategory, Integer> {

  @Autowired
  CategoryRepository categoryRepository;
  
  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (0 == value) {
      return true;
    }
    return categoryRepository.existsById(value);
  }

}
