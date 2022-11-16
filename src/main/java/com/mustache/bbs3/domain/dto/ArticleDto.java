package com.mustache.bbs3.domain.dto;


import com.mustache.bbs3.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ArticleDto {
    private Long id;

    private String title;

    private String content;


    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}