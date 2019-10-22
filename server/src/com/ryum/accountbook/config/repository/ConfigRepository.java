package com.ryum.accountbook.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryum.accountbook.config.dto.Config;
import com.ryum.accountbook.config.enums.EnumConfig;

/**
 * 환경설정 Repository
 * 
 * @author ryum
 */
@Repository
public interface ConfigRepository extends JpaRepository<Config, EnumConfig> {

}
