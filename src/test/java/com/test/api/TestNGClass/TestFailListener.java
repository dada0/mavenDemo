package com.test.api.TestNGClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.types.resources.selectors.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import io.qameta.allure.Attachment;
public class TestFailListener extends TestListenerAdapter {
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		BaseTest bt = (BaseTest) tr.getInstance();
		System.out.println(tr);
		WebDriver driver = bt.getDriver();
		takePhoto(tr.getClass().toString(),tr.getMethod().toString(),driver);
		logCaseStep(tr);
		exceptedResult(tr);
	}
	

	/*@Attachment(value = "失败截图如下：",type = "image/png")
	public byte[]  takePhoto(WebDriver driver){
		byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}*/

	 public void takePhoto(String classname, String methodname,WebDriver driver) {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date currentTime = new Date();
	        String dateString = formatter.format(currentTime);
	        String screenName = classname+"_"+methodname+"_"+dateString+ ".png";
	        System.out.println(screenName);
	        File dir = new File("test-output/snapshot");
	        if (!dir.exists())
	            dir.mkdirs();
	        String screenPath = dir.getAbsolutePath() + "/" + screenName;
	        this.takeScreenshot(screenPath,driver);
	    }

	
	@Attachment(value = "Failure", type = "image/png")
    private byte[] takeScreenshot(String screenPath,WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenPath));
        } catch (IOException e) {
            System.out.println("Screen shot error: " + screenPath);
        }
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

	
	/**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "操作步骤如下：")
	public String logCaseStep(ITestResult tr){
		String step =  " 1、" +  tr.getInstance().toString();
		 step= step + " \n 2、" + tr.getTestClass().toString();
		 step= step + " \n 3、" + tr.getMethod().toString();
		return step;
	}

	/**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "期望结果如下：")
	public String exceptedResult(ITestResult tr){
		String result = "显示查询结果";
		return result;
	}



}
