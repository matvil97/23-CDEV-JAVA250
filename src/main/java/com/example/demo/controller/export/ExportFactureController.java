package com.example.demo.controller.export;

import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
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

            // Creation des en-tetes dans le tableau
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Désignation");
            headerRow.createCell(1).setCellValue("Quantité");
            headerRow.createCell(2).setCellValue("Prix unitaire");

            //  Ajouter données dans le tableau
            int rowNum = 1;
            for (LigneFacture ligneFacture : facture.getLigneFactures()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(ligneFacture.getArticle().getDesignation());
                row.createCell(1).setCellValue(ligneFacture.getQuantite());
                row.createCell(2).setCellValue(ligneFacture.getArticle().getPrix());
            }
        }

        workbook.write(response.getOutputStream());
    }

}
