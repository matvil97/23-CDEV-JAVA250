package com.example.demo.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ArticleDto;

@Service
public class ExportArticleXLSXService {

    @Autowired
    private ArticleService articleService;

    public void export(OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Article");

        Row headerRow = sheet.createRow(0);
        Cell cellHeaderLibelle = headerRow.createCell(0);
        cellHeaderLibelle.setCellValue("Libellé");

        Cell cellHeaderPrix = headerRow.createCell(1);
        cellHeaderPrix.setCellValue("Prix");

        int iRow = 1;
        for (ArticleDto articleDto : articleService.findAll()) {
            Row row = sheet.createRow(iRow++);
            Cell cellLibelle = row.createCell(0);
            Cell cellPrix = row.createCell(1);

            cellLibelle.setCellValue(articleDto.getLibelle());
            cellPrix.setCellValue(articleDto.getPrix());
        }

        workbook.write(outputStream);
        workbook.close();
    }

}
