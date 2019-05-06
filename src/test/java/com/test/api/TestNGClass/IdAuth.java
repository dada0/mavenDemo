package com.test.api.TestNGClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class IdAuth {
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
		  System.out.println("===iiiiiii====================================oooooooooooooooooooooo\niiiiiii====================================oooooooooooooooooooooo\niiiiiii====================================oooooooooooooooooooooo\n");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("=======  beforeMethod   =========\n");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("=======  afterMethod   =========\n");
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("=======  beforeClass   =========\n");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("=======  afterClass   =========\n");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("=======  beforeTest   =========\n");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("=======  afterTest   =========\n");
	  }

	  @BeforeSuite
	  public void beforeSuite() throws InterruptedException {
		  System.out.println("=======  beforeSuite   =========\n");
		  
		  //打开链接
		  System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\72.0.3626.121\\chromedriver.exe");
		  WebDriver  driver = new ChromeDriver();
		  driver.get("http://192.168.139.196:8086/cdzx/admin/login");
		  System.out.println("=======  打开链接   =========\n");
		  
			//等待元素出现  
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")));
		    Thread.sleep(5000);
		    //输入查询关键字
		    
			driver.findElement(By.id("username")).sendKeys("admin33");
			driver.findElement(By.id("password")).sendKeys("123456");
			Thread.sleep(2000);
			//点击查询按钮
			//driver.findElement(By.id(PageConstant.BTNKEY)).click();
			driver.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")).click();
			
			//driver.findElement(By.xpath(xpathExpression)).click();
			
			Thread.sleep(5000);
		  
		  
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("=======  afterSuite   =========\n");
	  }


}
