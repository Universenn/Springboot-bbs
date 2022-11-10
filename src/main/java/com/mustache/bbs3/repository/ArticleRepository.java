package com.mustache.bbs3.repository;

import com.mustache.bbs3.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
