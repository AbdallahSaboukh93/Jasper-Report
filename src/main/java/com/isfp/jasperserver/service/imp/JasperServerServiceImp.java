package com.isfp.jasperserver.service.imp;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.isfp.jasperserver.service.JasperServerService;

@Service
public class JasperServerServiceImp implements JasperServerService {

	public InputStream getStreamedContent() throws Exception {
	//	String url = "http://localhost:8081/jasperserver/rest_v2/reports/reports/report/test500.pdf?";
		String url = "http://localhost:8081/jasperserver/rest_v2/reports/reports/report/OriginalCase.pdf?";
		URL weburl = new URL(appendParamters(url));
		HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization",
				"Basic " + Base64.getEncoder().encodeToString(("jasperadmin" + ":" + "jasperadmin").getBytes()));
		InputStream inputStream = conn.getInputStream();
		return inputStream;

	}

	private String appendParamters(String url) {
		Map<String, String> paramters = new HashMap<>();
		paramters.put("selectedId", "63");
		paramters.put("courtClassId", "1");
		paramters.put("courtId", "2");
		paramters.put("panelId", "7");
		paramters.put("headerRelPath", "");
		paramters.put("userName", "abdllah");
	//	paramters.put("id", "5");
	//	paramters.put("DEPOSIT_DATE", "2021-01-01"); // yyyy-mm-dd
		String returnedURL = setParamterToUrl(paramters, url);
		return returnedURL;
	}

	private String setParamterToUrl(Map<String, String> paramters, String url) {
		String params = "";
		for (Map.Entry<String, String> entry : paramters.entrySet()) {
			params = params + entry.getKey() + "=" + entry.getValue() + "&";
		}
		return url + params;
	}

}
