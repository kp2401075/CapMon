//package com.capmon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class RateHttpClient {

	
	  public static final String BASE_URL = "http://localhost:8181/onos/v1/statistics/flows/link?device=of:0000000000000001&port=2";

    //public static final String BASE_URL ="http://localhost:8181/onos/v1/statistics/flows/link/";


    public String getRateData() {
        HttpURLConnection connection = null;
        InputStream inputStream = null;


        try {
            connection = (HttpURLConnection)(new URL(BASE_URL)).openConnection();
            String encoded = Base64.getEncoder().encodeToString(("karaf"+":"+"karaf").getBytes(StandardCharsets.UTF_8));  //Java 8
            connection.setRequestProperty("Authorization", "Basic "+encoded);

            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            StringBuffer stringBuffer = new StringBuffer();

            inputStream = connection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\r\n");

            }
            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error";

    }
    
}
