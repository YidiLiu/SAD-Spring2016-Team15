/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.HttpHelper;

/* Extend the HttpHelper to support PUT request */
public class AdvancedHttpHelper {
    public static String HttpUserReg(String urlString, JsonObject jsonObj, String operation) throws Exception{
        if(operation.equals("put")){
            System.out.println("Reached inside put");
            return httpPut(urlString, jsonObj.toString());
        }else{
            return HttpHelper.HttpUserReg(urlString, jsonObj, operation);
        }
    }
    
    public static String httpPut(String urlStr, String jsonStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        OutputStream out = conn.getOutputStream();
        Writer writer = new OutputStreamWriter(out, "UTF-8");
        writer.write(jsonStr);
        writer.close();
        out.close();
        return getHttpResponse(conn, 200);
    }
 
    private static String getHttpResponse(HttpURLConnection conn, int expectedReturnCode) throws IOException {
        System.out.println("response code:" + conn.getResponseMessage());
        if (conn.getResponseCode() != expectedReturnCode) {
            System.out.println("Custom Error:" + conn.getResponseCode());
            throw new IOException(conn.getResponseMessage());
        }
        
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                                                                     conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }
}
