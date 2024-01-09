package com.kh.springchap8.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUrlEncoderController {
	
	
	@GetMapping("/api/encoder/data")
	 public String allowBasic() {
		
			
		StringBuffer result = new StringBuffer();
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst");
		urlBuilder.append("?serviceKey=201310170600");
		urlBuilder.append("&pageNo=1");
		urlBuilder.append("&numOfRows=10");
		urlBuilder.append("&dataType=xml");
		urlBuilder.append("stnld=108");
		urlBuilder.append("&tmFc=201310170600");
		
		
		
		try {
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd;
			
			// 만약에 response 코드가 200 보다 크거나 300보다 작을 때
			// Http: 응답코드가 200 ~ 299 사이 성공
			//       	 응답코드가 300 ~ 399 리다이렉션
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
			
			String line;
			
			while((line = rd.readLine()) != null) {
				result.append(line).append("\n");
			}
			
			rd.close();
			conn.disconnect();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
		
	}

}
