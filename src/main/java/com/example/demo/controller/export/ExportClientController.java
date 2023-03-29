package com.example.demo.controller.export;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.ExportArticleCSVService;
import com.example.demo.service.ExportClientCSVService;

/**
 * Controller pour réaliser l'export des articles.
 */
@Controller
@RequestMapping("export/clients")
public class ExportClientController {

    @Autowired
    private ExportClientCSVService exportClientCSVService;

    /**
     * Export des articles au format CSV.
     */
    @GetMapping("csv")
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"export-clients.csv\"");
        PrintWriter writer = response.getWriter();
        exportClientCSVService.export(writer);
    }

}
