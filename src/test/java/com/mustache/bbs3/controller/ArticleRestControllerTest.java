package com.mustache.bbs3.controller;


import com.mustache.bbs3.domain.dto.ArticleAddRequest;
import com.mustache.bbs3.domain.dto.ArticleAddResponse;
import com.mustache.bbs3.domain.dto.ArticleDto;
import com.mustache.bbs3.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("해당 id의 글이 조회가 잘 되는지")
    void findSingle() throws Exception {
        Long id = 23l;

        given(articleService.getArticle(id))
                .willReturn(new ArticleDto(23l, "23제목", "23내용"));

        mockMvc.perform(get("/api/v1/articles/23"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).getArticle(id);
    }
    @Test
    @DisplayName("한 개의 게시글 등록하기")
    void addArticle() throws Exception {
        ArticleAddRequest dto = new ArticleAddRequest("제목입니다.", "내용입니다.");
        given(articleService.addArticle(any())).willReturn(new ArticleAddResponse(3L, dto.getTitle(), dto.getContent()));

        Long articleId = 24L;
        String url = String.format("/api/v1/articles/%d", articleId);

        mockMvc.perform(
                        post(url)
                                .content(objectMapper.writeValueAsBytes(new ArticleAddRequest("제목입니다.", "내용입니다.")))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목입니다."))
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).addArticle(refEq(dto));
    }
}