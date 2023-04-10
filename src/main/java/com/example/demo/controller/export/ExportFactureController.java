package com.example.demo.controller.export;

import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("export/factures")
public class ExportFactureController {

    @Autowired
    private FactureRepository factureRepository;

    @GetMapping("xlsx")
    public void exportAllXLSX(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition",
                "attachment; filename=\"export-factures.xlsx\"");
        Workbook workbook = new XSSFWorkbook();

        List<Facture> factures = factureRepository.findAll();

        for (Facture facture : factures) {
            Sheet sheet = workbook.createSheet("Facture " + facture.getId());

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Désignation");
            headerRow.createCell(1).setCellValue("Quantité");
            headerRow.createCell(2).setCellValue("Prix unitaire");


        }

        // Write the workbook to the response stream
        workbook.write(response.getOutputStream());
    }

}
