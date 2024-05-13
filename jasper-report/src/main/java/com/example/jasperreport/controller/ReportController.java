package com.example.jasperreport.controller;

import com.example.jasperreport.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;
    @GetMapping("/report")
    public void generatePdfReport() throws JRException, FileNotFoundException {
        reportService.exportReport();
        System.out.println("ReportGenerated..");

    }
}
