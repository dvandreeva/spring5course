package org.iproduct.spring.webfluxintro.dao;

import org.iproduct.spring.webfluxintro.model.Article;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ArticleRepositoryMock {
    private List<Article> articles = new CopyOnWriteArrayList<>(
            Arrays.asList(
                    new Article("11111", "New in Spring1", "webflux is here1", LocalDateTime.now()),
                    new Article("22222", "New in Spring2", "webflux is here2", LocalDateTime.now()),
                    new Article("33333", "New in Spring3", "webflux is here3", LocalDateTime.now())
            ));

    public Flux<Article> findAll() {
        return Flux.fromIterable(articles);
    }

    public Mono<Article> save(Article article) {
        article.setId(LocalDateTime.now().toString());
        articles.add(article);
        return Mono.just(article);
    }
}