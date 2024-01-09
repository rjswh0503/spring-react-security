package com.kh.springchap8.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApiJsonController {

    @GetMapping(value="/api/get1", produces= MediaType.APPLICATION_JSON_VALUE)
    public String allowBasic() {
        StringBuilder result = new StringBuilder();

        try {
            String apiUrl = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst";
            String apiKey = "KAHjjoG3vu1N9aErjNWbHchfz4ybu0mLi+owSp3Upaw3I60rSUZS7ZGgszXmavp2Tmww49ycsKuTU47eK8yp2w==";
            String numOfRows = "10";
            String pageNo = "3";
            String dataType = "xml";
            String stnId = "108";
            String tmFc = "202401090600";
            String encodedApiKey = URLEncoder.encode(apiKey, "UTF-8");
            String encodedUrl = String.format("%s?serviceKey=%s&numOfRows=%s&pageNo=%s&dataType=%s&stnId=%s&tmFc=%s",
                    apiUrl, encodedApiKey, numOfRows, pageNo, dataType, stnId, tmFc);

            URL url = new URL(encodedUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        //json 파일로 변환해서 보여주기 
        
        String jsonResult = convertXmlToJson(result.toString());
        return jsonResult;
        //return result.toString();
    }
    //xml로 보이는 파일을 json 형식으로 변환해서 화면에 출력하는 메서드
    private String convertXmlToJson(String xmlData) {
    	JSONObject jsonObj = XML.toJSONObject(xmlData);
    	return jsonObj.toString();
    	
    }
}