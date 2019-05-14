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
	 public WebDriver driver;
	 
	    public TestFailListener(WebDriver driver) {
	        this.driver = driver;
	    }
	    @Attachment(value = "Failure", type = "image/png")
	    private byte[] takeScreenshot(String screenPath) {
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
	 
	    public void takeScreenshot(String classname, String methodname) {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date currentTime = new Date();
	        String dateString = formatter.format(currentTime);
	        String screenName = classname+"_"+methodname+"_"+dateString+ ".png";
	        System.out.println(screenName);
	        File dir = new File("test-output/snapshot");
	        if (!dir.exists())
	            dir.mkdirs();
	        String screenPath = dir.getAbsolutePath() + "/" + screenName;
	        this.takeScreenshot(screenPath);
	    }


}
