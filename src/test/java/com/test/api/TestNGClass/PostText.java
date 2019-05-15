package com.test.api.TestNGClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.alibaba.fastjson.JSONObject;

public class PostText {
	public Assertion assertion;
    
    @BeforeClass
    public void beforeClass() {
        assertion = new Assertion();
    }

    @BeforeMethod
    public void runBeforeMethod() {
        // 打开httpclient,相当于打开一个浏览器
        HttpUtils.OpenHttpClient();//这边一定要记得在测试用例开始之前打开浏览器，否则会出现空指针的错误
    }
    @AfterMethod
    public void runAfterMethod() {
        // 打开httpclient,相当于打开一个浏览器
        HttpUtils.CloseHttpClient();
    }
    
  @Test
  public void f() throws ClientProtocolException, IOException {
        String loginUrl = "http://192.168.139.196:8086/login?loginName=admin&passWord=123456";
        JSONObject json = HttpUtils.visitUrlPost(loginUrl);
//        boolean success = json.getBoolean("success");
        Boolean success = null;
        if(json.get("message").equals("success")){
            success = true;
        }else{
            success = false;
        }
//        boolean success = json.getBoolean("message");
        String enterTrainningUrl = "http://192.168.139.196:8086?appName=&createTimeEnd=&createTimeStart=&creatorName=&page=1&size=5";
        System.out.println(enterTrainningUrl);
        JSONObject enterObj = HttpUtils.visitUrlGet(enterTrainningUrl);
        System.out.println(enterObj.toString());
        Boolean success2 = null;
        if(json.get("message").equals("success")){
            success2 = true;
        }else{
            success2 = false;
        }
        assertion.assertTrue(success);
  }
}
