package com.isfp.jasperserver.controller;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isfp.jasperserver.service.JasperServerService;
import com.isfp.jasperserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/jasperreport")
public class JasperServerController {

	@Autowired
	JasperServerService jasperServerService;

	@Autowired
	ReportService reportService;

	@GetMapping(produces = "application/pdf")
	public ResponseEntity<InputStreamResource> getReport() {
		InputStream inputStream = null;
		try {
			inputStream = jasperServerService.getStreamedContent();

			return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
					.body(new InputStreamResource(inputStream));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping("report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return reportService.exportReport(format);
	}
}
