package com.ryum.accountbook.history.dto;

import com.ryum.accountbook.common.enums.EnumUnit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 결제내역
 * 
 * @author ryum
 */
@Entity
@Getter @Setter
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx; // 고유 인덱스

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime date; // 날짜

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumUnit unit; // 단위

	@Column
	private int accountIdx; // 결제수단 인덱스

	@Column
	private int categoryIdx; // 카테고리 인덱스

	@Column(nullable = false)
	private String title; // 타이틀

	@Column
	private String message; // 메세지

	@Column
	private int price; // 가격

	public void setIdx(int idx) {
		this.idx = idx;
	}

}
