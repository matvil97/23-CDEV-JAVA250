package com.example.demo.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportArticleCSVServiceIntTest {

    @Autowired
    private ExportArticleCSVService articleCSVService;

    @Test
    public void exportDansConsole() {
        PrintWriter printWriter = new PrintWriter(System.out);
        articleCSVService.export(printWriter);
        printWriter.flush();
    }

    @Test
    public void exportDansUnFichier() throws IOException {
        FileOutputStream out = new FileOutputStream("./target/articles.csv");
        PrintWriter printWriter = new PrintWriter(out);
        articleCSVService.export(printWriter);
        printWriter.flush();
        out.close();
    }
}