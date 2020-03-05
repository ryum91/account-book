package com.ryum.accountbook.account.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;

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

	public void setIdx(int idx) {
		this.idx = idx;
	}
}
