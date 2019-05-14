package com.test.api.TestNGClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



import ru.yandex.qatools.allure.annotations.Attachment;

public class TestFailListener extends TestListenerAdapter {
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		BaseTest bt = (BaseTest) tr.getInstance();
		WebDriver driver = bt.getDriver();
		takePhoto(driver);
		logCaseStep(tr);
		exceptedResult(tr);
	}
	

	@Attachment(value = "ʧ�ܽ�ͼ���£�",type = "image/png")
	public byte[]  takePhoto(WebDriver driver){
		byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	/**
	 * ��ӡ���Բ���
	 * @param tr
	 */
	@Attachment(value = "�����������£�")
	public String logCaseStep(ITestResult tr){
		String step = "1���������  2������ٶȵ�ַ";
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
