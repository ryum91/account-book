package com.ryum.accountbook.config.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ryum.accountbook.config.enums.EnumConfig;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 환경설정 DTO
 * 
 * @author ryum
 */
@Entity
@Getter @Setter
public class Config {

	@Id
	@Enumerated(EnumType.STRING)
	private EnumConfig key; // 키

	@Column
	private String value; // Value

	public Config() {
		super();
	}

	public Config(EnumConfig key, String value) {
		this.key = key;
		this.value = value;
	}

	public Config(EnumConfig key, boolean value) {
		this(key, Boolean.toString(value));
	}

	public Config(EnumConfig key, int value) {
		this(key, Integer.toString(value));
	}

	@JsonIgnore
	public boolean getBooleanValue() {
		return Boolean.parseBoolean(value);
	}

	@JsonIgnore
	public int getIntValue() {
		return Integer.parseInt(value);
	}

	@JsonIgnore
	public String getStringValue() {
		return value;
	}

	public EnumConfig getKey() {
		return this.key;
	}
}
