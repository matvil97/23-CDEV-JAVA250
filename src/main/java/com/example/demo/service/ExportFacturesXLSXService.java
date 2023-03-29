package com.example.demo.service;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ArticleDto;

@Service
public class ExportFacturesXLSXService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ClientService clientService;

    public void export(OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        workbook.write(outputStream);
        workbook.close();
    }

}
