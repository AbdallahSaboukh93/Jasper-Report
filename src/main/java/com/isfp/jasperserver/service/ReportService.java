package com.isfp.jasperserver.service;

import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException;

	public Blob exportReportnativeQuery(String path, Map<String, Object> params)
			throws FileNotFoundException, JRException, SQLException;

}
