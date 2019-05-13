package com.test.api.TestNGClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;


public class HttpUtils {
	 static CloseableHttpClient httpclient = null;

	    public static void OpenHttpClient()
	    {
	        //打开浏览器
	        httpclient = HttpClients.createDefault();
	    }

	    public static void CloseHttpClient()
	    {
	        //关闭浏览器
	        try {
	            httpclient.close();
	        } catch (IOException e) {
	            
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        httpclient = null;
	    }

	    public static JSONObject visitUrlPost(String url)
	    {
	        //CloseableHttpClient httpclient = HttpClients.createDefault();
	        
//	        HttpGet httpGet = new HttpGet(url);
	        HttpPost httpPost = new HttpPost(url);
//	        HttpPost httpPost = new HttpPost(url);
	        JSONObject jsonObj=null;
	        try {
//	            CloseableHttpResponse response = httpclient.execute(httpGet);
	            CloseableHttpResponse response = httpclient.execute(httpPost);
	            HttpEntity entity = response.getEntity();
	            
	            StringBuilder jsonStr = new StringBuilder();
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"),1024);
	            String line = null;
	            while ((line = bufferedReader.readLine()) != null) {
	                jsonStr.append(line + "/n");
	            } 
	            EntityUtils.consume(entity);
	            //获取JSON对象的值
	            jsonObj = JSONObject.parseObject(jsonStr.toString());
//	            String jsonString = JSONObject.toJSONString(jsonStr.toString());
	            response.close();


	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();

	        }

	        
	        return jsonObj;
	    }
	    public static JSONObject visitUrlGet(String url)
	    {
	        //CloseableHttpClient httpclient = HttpClients.createDefault();
	        
	        HttpGet httpGet = new HttpGet(url);
//	        HttpPost httpPost = new HttpPost(url);
	        JSONObject jsonObj=null;
	        try {
//	            CloseableHttpResponse response = httpclient.execute(httpGet);
	            CloseableHttpResponse response = httpclient.execute(httpGet);
	            HttpEntity entity = response.getEntity();
	           
	            StringBuilder jsonStr = new StringBuilder();
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"),1024);
	            String line = null;
	            while ((line = bufferedReader.readLine()) != null) {
	                jsonStr.append(line + "/n");
	            }
	            EntityUtils.consume(entity);
	            //获取JSON对象的值
	            jsonObj = JSONObject.parseObject(jsonStr.toString());
//	            String jsonString = JSONObject.toJSONString(jsonStr.toString());
	            response.close();


	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();

	        }

	        
	        return jsonObj;
	    }
}
