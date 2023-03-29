package com.example.demo.controller.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.demo.dto.ArticleDto;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ExportArticleCSVService;
import com.example.demo.service.ExportArticleXLSXService;

/**
 * Controller pour réaliser l'export des articles.
 */
@Controller
@RequestMapping("export/articles")
public class ExportArticleController {

    @Autowired
    private ExportArticleCSVService exportArticleCSVService;
    @Autowired
    private ExportArticleXLSXService exportArticleXLSXService;

    /**
     * Export des articles au format CSV.
     */
    @GetMapping("csv")
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"export-articles.csv\"");
        PrintWriter writer = response.getWriter();
        exportArticleCSVService.export(writer);
    }

    @GetMapping("xlsx")
    public void exportXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition",
            "attachment; filename=\"export-articles.xlsx\"");
        exportArticleXLSXService.export(response.getOutputStream());
    }

}
