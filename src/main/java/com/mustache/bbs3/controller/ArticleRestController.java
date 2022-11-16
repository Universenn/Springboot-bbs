package com.mustache.bbs3.controller;

import com.mustache.bbs3.domain.dto.ArticleAddRequest;
import com.mustache.bbs3.domain.dto.ArticleAddResponse;
import com.mustache.bbs3.domain.dto.ArticleDto;
import com.mustache.bbs3.domain.dto.HospitalResponse;
import com.mustache.bbs3.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id) { // ResponseEntity도 DTO타입
        ArticleDto articleDto = articleService.getArticle(id); // DTO
        return ResponseEntity.ok().body(articleDto); // Return은 DTO로
    }

    @PostMapping("/{id}")
    public ResponseEntity<ArticleAddResponse> add(@RequestBody ArticleAddRequest articleAddRequest){

        ArticleAddResponse articleAddResponse = articleService.addArticle(articleAddRequest);

        //200 ok if articleAddResponse exists
        return ResponseEntity.ok().body(articleAddResponse);
    }
}
