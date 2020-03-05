package com.ryum.accountbook.config.service;

import com.ryum.accountbook.config.dto.Config;
import com.ryum.accountbook.config.enums.EnumConfig;
import com.ryum.accountbook.config.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 환경설정 Service
 * 
 * @author ryum
 */
@Service
public class ConfigService {

	@Autowired
	ConfigRepository configRepository;

	/**
	 * Boolean 환경설정 조회
	 * 
	 * @param key
	 * @return
	 */
	public boolean selectBoolean(EnumConfig key) {
		return select(key).getBooleanValue();
	}

	/**
	 * Int 환경설정 조회
	 * 
	 * @param key
	 * @return
	 */
	public int selectInt(EnumConfig key) {
		return select(key).getIntValue();
	}

	/**
	 * String 환경설정 조회
	 * 
	 * @param key
	 * @return
	 */
	public String selectString(EnumConfig key) {
		return select(key).getStringValue();
	}

	/**
	 * 환경설정 조회
	 * 
	 * @param key
	 * @return
	 */
	private Config select(EnumConfig key) {
		if (null == key) {
			throw new NullPointerException("key is null");
		}
		return configRepository.findById(key).orElse(new Config(key, key.getDefaultValue()));
	}

	/**
	 * Boolean 환경설정 저장
	 * 
	 * @param config
	 * @return
	 */
	public Config insertBoolean(EnumConfig key, boolean value) {
		return insert(new Config(key, value));
	}

	/**
	 * Int 환경설정 저장
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Config insertInt(EnumConfig key, int value) {
		return insert(new Config(key, value));
	}

	/**
	 * String 환경설정 저장
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Config insertString(EnumConfig key, String value) {
		return insert(new Config(key, value));
	}

	/**
	 * 환경설정 저장
	 * 
	 * @param config
	 * @return
	 */
	private Config insert(Config config) {
		if (null == config) {
			throw new NullPointerException("config is null");
		}
		if (null == config.getKey()) {
			throw new NullPointerException("key is null");
		}
		return configRepository.save(config);
	}
}