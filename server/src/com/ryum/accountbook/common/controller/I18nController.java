package com.ryum.accountbook.common.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * i18n Controller
 * @author ryum
 */
@RestController
@RequestMapping("/i18n")
public class I18nController implements InitializingBean {

	private Map<String, Properties> propertiesMap = new ConcurrentHashMap<>();

	@Override
	public void afterPropertiesSet() throws Exception {
		try (InputStream koIs = new ClassPathResource("i18n/message_ko.properties").getInputStream();
			 InputStream enIs = new ClassPathResource("i18n/message_en.properties").getInputStream()) {
			Properties ko = new Properties();
			Properties en = new Properties();
			ko.load(koIs);
			en.load(enIs);
			propertiesMap.put("ko", ko);
			propertiesMap.put("en", en);
		}
	}
	
	@GetMapping("/{lang}")
	public Properties i18n(@PathVariable("lang") String lang) throws IOException {
		return propertiesMap.get(lang);
	}

}
