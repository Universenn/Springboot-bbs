package com.mustache.bbs3.service;

import com.mustache.bbs3.domain.dto.ArticleDto;
import com.mustache.bbs3.domain.dto.HospitalResponse;
import com.mustache.bbs3.domain.entity.Article;
import com.mustache.bbs3.domain.entity.Hospital;
import com.mustache.bbs3.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    // HospitalResponse 에 이 로직을 넣을 수도 있습니다.
    public ArticleDto getArticle(Long id) {
        Optional<Article> optHospital = articleRepository.findById(id); // Entity
        Article article = optHospital.get();
        ArticleDto articleDto = article.of(article); // DTO
        return articleDto;
    }
}