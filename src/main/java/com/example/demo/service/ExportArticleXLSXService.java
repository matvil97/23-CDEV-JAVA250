package com.example.demo.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ArticleDto;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;

@Service
public class ExportArticleXLSXService {

    @Autowired
    private ArticleRepository articleRepository;

    public void export(OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Article");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.DASHED);
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row headerRow = sheet.createRow(0);
        Cell cellHeaderLibelle = headerRow.createCell(0);
        cellHeaderLibelle.setCellValue("Libellé");

        Cell cellHeaderPrix = headerRow.createCell(1);
        cellHeaderPrix.setCellValue("Prix");

        int iRow = 1;
        for (Article article : articleRepository.findAll()) {
            Row row = sheet.createRow(iRow++);
            Cell cellLibelle = row.createCell(0);
            Cell cellPrix = row.createCell(1);

            cellLibelle.setCellValue(article.getLibelle());
            cellPrix.setCellValue(article.getPrix());
        }

        workbook.write(outputStream);
        workbook.close();
    }

}
