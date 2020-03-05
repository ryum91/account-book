package com.ryum.accountbook.category.dto;

import com.ryum.accountbook.common.enums.EnumUnit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 카테고리 DTO
 * 
 * @author ryum
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "unit", "name" }) })
@Getter @Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx; // 인덱스

	@Column(name = "unit")
	@Enumerated(EnumType.STRING)
	private EnumUnit unit; // 단위

	@Column(name = "name")
	private String name; // 카테고리명
	
	@Column
	private String icon;	// 아이콘

	@Column
	private int parentIdx; // 부모 카테고리 인덱스

	public Category() {
		super();
	}

	public Category(EnumUnit unit, String name, String icon) {
		this.unit = unit;
		this.name = name;
		this.icon = icon;
	}

	public Category(EnumUnit unit, String name, String icon, int parentIdx) {
		this(unit, name, icon);
		this.parentIdx = parentIdx;
	}

}
