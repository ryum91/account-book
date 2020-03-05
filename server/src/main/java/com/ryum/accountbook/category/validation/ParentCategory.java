package com.ryum.accountbook.category.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ParentCategoryValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParentCategory {

	String message() default "Email is Duplication";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
