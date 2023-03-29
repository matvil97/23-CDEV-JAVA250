package com.example.demo.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ArticleDto;

@Service
public class ExportArticleCSVService {

    @Autowired
    private ArticleService articleService;

    public void export(PrintWriter writer) {
        writer.println("Libellé;Prix");
        List<ArticleDto> articleDtoList = articleService.findAll();
        for (ArticleDto articleDto : articleDtoList) {
            writer.println(articleDto.getLibelle() + ";" + articleDto.getPrix());
        }
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
