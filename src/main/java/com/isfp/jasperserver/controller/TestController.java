package com.isfp.jasperserver.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isfp.jasperserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/reports")
public class TestController {
	@Autowired
	ReportService reportService;
	
	
	@GetMapping
	public String generateReport() throws FileNotFoundException, JRException {
		return reportService.exportReport("pdf");
	}
}

