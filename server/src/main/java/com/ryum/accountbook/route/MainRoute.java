package com.ryum.accountbook.route;

import com.ryum.accountbook.account.service.AccountService;
import com.ryum.accountbook.category.service.CategoryService;
import com.ryum.accountbook.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class MainRoute {

	@Autowired
    AccountService accountService;
	
	@Autowired
    CategoryService categoryService;

	@Autowired
    HistoryService historyService;

	@Bean
	public RouterFunction<ServerResponse> account() {
		String baseUrl = "/api/account";
		return route(GET(baseUrl), req -> ok().syncBody(accountService.selectAll()));
	}

	@Bean
	public RouterFunction<ServerResponse> category() {
		String baseUrl = "/api/category";
		return route(GET(baseUrl), req -> ok().syncBody(categoryService.selectAll()));
	}

	@Bean
	public RouterFunction<ServerResponse> history() {
		String baseUrl = "/api/history";
		return route(GET(baseUrl), req -> ok().syncBody(historyService.selectAll()));
	}
	
	@Bean
	public RouterFunction<ServerResponse> dist() {
		return
			route(GET("/dist/**"), req -> ok().syncBody(new ClassPathResource(req.path())))
			.andRoute(GET("/**"), req -> ok().syncBody(new ClassPathResource("/dist/index.html")))
			;
	}
	
}
