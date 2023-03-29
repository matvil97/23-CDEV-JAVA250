package com.example.demo.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test unitaire
 */
public class ExportArticleCSVServiceTest {

    @Test
    public void exportDansConsole() {
        ExportArticleCSVService exportService = new ExportArticleCSVService();
        exportService.setArticleService(new ArticleServiceFakeImpl());

        PrintWriter printWriter = new PrintWriter(System.out);
        exportService.export(printWriter);
        printWriter.flush();
    }

    @Test
    public void exportDansUnFichier() throws IOException {
        ExportArticleCSVService exportService = new ExportArticleCSVService();
        exportService.setArticleService(new ArticleServiceFakeImpl());

        FileOutputStream out = new FileOutputStream("./target/articles.csv");
        PrintWriter printWriter = new PrintWriter(out);
        exportService.export(printWriter);
        printWriter.flush();
        out.close();
    }
}