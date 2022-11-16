package com.mustache.bbs3.controller;

import com.mustache.bbs3.domain.dto.ArticleDto;
import com.mustache.bbs3.domain.entity.Article;
import com.mustache.bbs3.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

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
//    @Test
//    @DisplayName("Json 확인")
//    void jsonResponse() throws Exception {
//        ArticleDto articleDto =
//                ArticleDto.builder()
//                        .id(23L)
//                        .title("23제목")
//                        .content("23내용")
//                        .build();
//        given(articleService.getArticle(23L))
//                .willReturn(articleDto);
//
//
//        Long articleId = 1L;
//        String url = String.format("/api/v1/hospitals/%d", articleId);
//        mockMvc.perform(get(url))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").exists())
//                .andExpect(jsonPath("$.content").value("23내용"))
//                .andDo(print());
//
//        verify(articleService).getArticle(articleId);
//    }
}