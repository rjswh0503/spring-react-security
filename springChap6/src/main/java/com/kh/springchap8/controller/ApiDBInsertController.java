package com.kh.springchap8.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ApiDBInsertController {
	@GetMapping("/day_info1/add")
	public String DBInsert() {
		//데이터를 시작하기 전에는 StringBuilder
		StringBuilder result = new StringBuilder();
		try {
			String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
            String apiKey = "KAHjjoG3vu1N9aErjNWbHchfz4ybu0mLi+owSp3Upaw3I60rSUZS7ZGgszXmavp2Tmww49ycsKuTU47eK8yp2w==";
            String numOfRows = "10";
            String pageNo = "1";
            String dataType = "json";
            String base_date = "20240109";
            String base_time = "0600";
            String nx = "55";
            String ny = "127";
            String encodedApiKey = URLEncoder.encode(apiKey, "UTF-8");
            String encodedUrl = String.format("%s?serviceKey=%s&numOfRows=%s&pageNo=%s&dataType=%s&base_date=%s&base_time=%s&nx=%s&ny=%s",
                    apiUrl, encodedApiKey, numOfRows, pageNo, dataType, base_date, base_time,nx,ny);
			URL url = new URL(encodedUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			//화면에 데이터가 출력될 수 있도록 readLine을 써서 출력
			String line;
			while((line = reader.readLine()) != null) {
				result.append(line);
				
			}
			
			reader.close();
			connection.disconnect();
			//데이터베이스에 저장하는 메서드 실행
			insertIntoOracleDB(result.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return result.toString();
		
	}
	
	private void insertIntoOracleDB(String data) {
		String jdbcUrl = "jdbc:oracle:thin:@database-1.c5q8eoyem9vs.ap-northeast-2.rds.amazonaws.com:1521:orcl";
		String username = "admin";
		String password = "fiveguys1234";
		
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			
			String sql = "Insert into weather (id, data) Values(weather_seq.NEXTVAL, ?)";
			
			try(PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setString(1, data);
				statement.executeUpdate();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	

}
