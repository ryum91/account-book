package com.ryum.accountbook.account.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * 결제수단
 * 
 * @author ryum
 */
@Entity
@Getter @Setter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx; // 인덱스

	@Column(unique = true)
	private String name; // 이름

	@Column
	private String color; // 색상

	@Column
	private int initialBalance; // 초기 잔액
}
