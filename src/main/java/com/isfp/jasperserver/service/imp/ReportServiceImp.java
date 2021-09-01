package com.isfp.jasperserver.service.imp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.isfp.jasperserver.entity.UserEntity;
import com.isfp.jasperserver.repository.UserRepository;
import com.isfp.jasperserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

@Service
public class ReportServiceImp implements ReportService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

		String path = "D:\\reports";
		List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
		File file = ResourceUtils.getFile("classpath:report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
		Map<String, Object> params = new HashMap<>();
		params.put("Created By", "Shorouk");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\report.html");
		} else if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\report.pdf");
		}

		return "report generated in " + path;

	}

	public void exportReport(Integer reportFormat) {

		HashMap jasperParameter = new HashMap();
		String reportName;
		jasperParameter.put("headerRelPath", "");

		String reportRelPath = "/reports/reports/JSPR0012.jasper";
		reportName = "JSPR0012";
	//	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

		
	}
}
