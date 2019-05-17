package com.test.api.TestNGClass;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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
		WebDriver driver = bt.getDriver();
		operationTakePhoto(driver);
		try {
			takePhoto(tr.getClass().toString(),tr.getMethod().toString(),driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logCaseStep(tr);
		exceptedResult(tr);
	}
	

	@Attachment(value = "����ʧ�ܽ�ͼ���£�",type = "image/png")
	public static byte[]  operationTakePhoto(WebDriver driver){
		byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
	@Attachment(value = "����ʧ�ܽ�ͼ���£�",type = "image/png")
	 public void takePhoto(String classname, String methodname,WebDriver driver) throws Exception {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date currentTime = new Date();
	        String dateString = formatter.parse(currentTime.toString()).toString();
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
	 * ��ӡ���Բ���
	 * @param tr
	 */
	@Attachment(value = "�����������£�")
	public String logCaseStep(ITestResult tr){
		String step =  " 1��" +  tr.getInstance().toString();
		 step= step + " \n 2��" + tr.getTestClass().toString();
		 step= step + " \n 3��" + tr.getMethod().toString();
		return step;
	}

	/**
	 * ��ӡ���Բ���
	 * @param tr
	 */
	@Attachment(value = "����������£�")
	public String exceptedResult(ITestResult tr){
		String result = "��ʾ��ѯ���";
		return result;
	}



}
