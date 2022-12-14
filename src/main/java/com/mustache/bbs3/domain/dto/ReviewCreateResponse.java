package com.mustache.bbs3.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String message;
}