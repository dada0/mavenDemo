package com.test.api.TestNGClass;

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
		 /*System.out.println(tr);
		 Object currentClass = tr.getInstance();  
		 System.out.println(currentClass);
	     WebDriver driver = ((BaseTest) currentClass).getDriver(); */
	     System.out.println(driver);
		if(driver != null) {
			System.out.println( " ************  " + driver);
			takePhoto(driver);
			logCaseStep(tr);
			exceptedResult(tr);
		}
	}
	

	@Attachment(value = "失败截图如下：",type = "image/png")
	public byte[]  takePhoto(WebDriver driver){
		byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	/**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "操作步骤如下：")
	public String logCaseStep(ITestResult tr){
		String step = "1、打开浏览器  2、输入百度地址";
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
