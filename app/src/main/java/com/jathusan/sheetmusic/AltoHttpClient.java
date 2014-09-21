package com.jathusan.sheetmusic;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AltoHttpClient {

    public static String getBufferResponse(String url){

        StringBuilder builder = null;

        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            HttpResponse response = client.execute(request);

            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            builder = new StringBuilder();

            for (String line = null; (line = br.readLine()) != null; ) {
                builder.append(line).append("\n");
            }
        } catch (Exception e){
            Log.e("HttpClient", "Exception while executing http request");
        }

        return builder.toString();
    }

}
