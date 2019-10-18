package com.ryum.accountbook.config.enums;

/**
 * 환경설정 Enum
 * @author ryum
 */
public enum EnumConfig {

	BOOLEAN_INIT_CATEGORY_INSERT(true),				// 초기 데이터 삽입
	;
	
	private final String defaultValue;
	
	private EnumConfig(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	private EnumConfig(boolean defaultValue) {
		this(Boolean.toString(defaultValue));
	}
	
	private EnumConfig(int defaultValue) {
		this(Integer.toString(defaultValue));
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
}
