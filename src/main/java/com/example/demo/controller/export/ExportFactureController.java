package com.example.demo.controller.export;

import com.example.demo.repository.FactureRepository;
import com.example.demo.service.ExportFacturesXLSXService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.PngImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Controller pour réaliser l'export des factures.
 */
@Controller
@RequestMapping("export/factures")
public class ExportFactureController {

    @Autowired
    private ExportFacturesXLSXService exportFacturesXLSXService;

    @Autowired
    private FactureRepository factureRepository;


    @GetMapping("xlsx")
    public void exportAllXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition",
            "attachment; filename=\"export-factures.xlsx\"");
        exportFacturesXLSXService.export(response.getOutputStream());
    }

    /**
     * Export des clients au format PDF.
     */
    @GetMapping("{id}/pdf")
    public void exportCSV(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        response.setHeader("Content-Disposition", "attachment; filename=\"export-facture-" + id + ".pdf\"");
        OutputStream outputStream = response.getOutputStream();
        // TODO

    
    }
}
