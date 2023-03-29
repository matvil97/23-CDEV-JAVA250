package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.ArticleDto;
import com.google.common.collect.Lists;

public class ArticleServiceFakeImpl implements ArticleService {

    @Override
    public List<ArticleDto> findAll() {
        ArticleDto articleDto = new ArticleDto(
            99L,
            "Faux Article 1",
            10,
            "http://amazon.com/artile/99/img");
        ArrayList<ArticleDto> articleDtos = Lists.newArrayList(articleDto);
        return articleDtos;
    }
}
