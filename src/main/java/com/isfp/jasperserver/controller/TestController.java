package com.isfp.jasperserver.controller;

import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isfp.jasperserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class TestController {
	@Autowired
	ReportService reportService;

	@GetMapping
	public String generateReport() throws FileNotFoundException, JRException {
		return reportService.exportReport("pdf");
	}

	@GetMapping("/nativepdf")
	public ResponseEntity<InputStreamResource> exportReportnativeQuery()
			throws FileNotFoundException, JRException, SQLException {
		String path = "classpath:reports/nativesqlreport.jasper";
		Map<String, Object> params = new HashMap<>();
		params.put("Created", "abdallah");
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
				.body(new InputStreamResource(reportService.exportReportnativeQuery(path, params).getBinaryStream()));

	}

	@GetMapping("/native")
	public Blob exportReportnativeQueryBlob() throws FileNotFoundException, JRException, SQLException {
		String path = "classpath:reports/nativesqlreport.jasper";
		// to convert from json to object
		// ObjectMapper objectMapper = new ObjectMapper();
		// Properties properties = objectMapper.readValue(userEntity.getProperties(),
		// Properties.class);
		// params comes from json
		Map<String, Object> params = new HashMap<>();
		params.put("Created", "abdallah");
		return reportService.exportReportnativeQuery(path, params);

	}
}
