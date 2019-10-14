package com.ryum.accountbook.category.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ryum.accountbook.common.enums.EnumUnit;

import lombok.Getter;
import lombok.Setter;

/**
 * 카테고리 DTO
 * @author ryum
 */
@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(
		columnNames = {"unit", "name"}
	)
})
@Getter @Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;			// 인덱스
	
	@Column(name = "unit")
	private EnumUnit unit;		// 단위
	
	@Column(name = "name")
	private String name;		// 카테고리명
	
	@Column
	private int parentIdx;		// 부모 카테고리 인덱스
}
