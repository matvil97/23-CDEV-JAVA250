package com.example.demo.service;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.ClientRepository;

@Service
public class ExportFacturesXLSXService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ClientRepository clientRepository;

    public void export(OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        workbook.write(outputStream);
        workbook.close();
    }

}
