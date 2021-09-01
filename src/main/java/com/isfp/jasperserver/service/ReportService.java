package com.isfp.jasperserver.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;


public interface ReportService {
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException;
}
