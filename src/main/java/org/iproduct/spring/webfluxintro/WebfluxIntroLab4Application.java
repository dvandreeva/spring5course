package org.iproduct.spring.webfluxintro;

import org.iproduct.spring.webfluxintro.web.ArticleHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@SpringBootApplication
public class WebfluxIntroLab4Application {

	@Bean
	public RouterFunction<ServerResponse> routes (ArticleHandler handler) {
		return RouterFunctions.route(GET("/api/articles"), handler::all)
				.andRoute(POST("/api/articles"), handler::create);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebfluxIntroLab4Application.class, args);
	}

}

