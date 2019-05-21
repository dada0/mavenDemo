package com.test.api.TestNGClass;

import org.testng.annotations.Test;

import com.test.data.ReadExcel;
import com.test.data.function;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class IdAuth extends BaseTest {
	Map<Integer,ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
 // @Test(dataProvider="dp")
  public void w(Integer n, String s) throws Exception {
	  System.out.println("n is "+n);
	  System.out.println("s is "+s);
	  Assert.assertEquals(Integer.valueOf(2), n);
  }
  @Test(description = "百度搜索")
  public void baiduSearchTest() throws Exception {
      String url = "http://www.baidu.com";
      System.out.println("url:"+url);
      driver.get(url);
      driver.findElement(By.id("kw")).sendKeys("galen2016");
      driver.findElement(By.id("s11")).click();
  }

  @Test(description = "搜狗搜索")
  public void sougouSearchTest(){
      driver.get("https://www.sogou.com");
      driver.findElement(By.id("query1")).sendKeys("galen2016");
  }
  @Test(description ="导入")
  public void toLead () {
	  
	  
  }
  
  @Test(description = "测试新增人员")
  @Step("打开cdzx登陆页面实行免登操作")
  @Description("测试allure report")
  public void f() throws Exception  {
		
	  //打开链接
	 /* System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\72.0.3626.121\\chromedriver.exe");*/
	  driver.get("http://192.168.139.196:8086/cdzx/admin/login");
	  System.out.println("第一个 "  + driver.manage().window());
	  System.out.println("第一个 "  + driver.getWindowHandle());
	  
		//等待元素出现  
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")));
	    Thread.sleep(5000);
	    //输入查询关键字
	    
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Intasect_123");
		Thread.sleep(2000);
		//点击查询按钮
		driver.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")).click();
		
		//找到菜单
		 Thread.sleep(5000);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a")));
		driver.findElement(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a")).click();
		
		//打开新增叶片
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/dl/dd[1]/a")));
		driver.findElement(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/dl/dd[1]/a")).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"LAY_app_body\"]/div[2]/iframe")));
		System.out.println("没有进入新增 当前所有  \n\n\n\n\n " +driver.getWindowHandles() +"\n\n\n");
		//赋值
			if(map != null ) {
				   for (Entry<Integer, ArrayList<String>> m : map.entrySet()) 
				   {
					   
					  System.out.println("key:" + m.getKey() + " value:" + m.getValue());
					  //获取到头部
					  if(m.getKey() != null && "0".equals(m.getKey().toString())) 
					  {
						  if (m.getValue().size()>0) {
							for(int i =0;i<m.getValue().size();i++) {
							}
						}
					  }
					  else 
					  {
						  //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user\"]")));
							System.out.println("第二个 "  + driver.manage());
							  System.out.println("第二个 "  + driver.getWindowHandle());
							java.util.List<WebElement> l = driver.findElements(By.xpath("//form[@id=\"userListForm\"]//a[@id=\"adduser\"]"));
							  if(l.size()==0) {
								  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"LAY_app_body\"]/div[2]/iframe")));
								  WebElement ths= driver.findElement(By.xpath("//form[@id=\"userListForm\"]//a[@id=\"adduser\"]"));
								  if(ths == null) {
										driver.close();     
									}else {
										ths.click();
									}
							  }else {
								  WebElement ths= driver.findElement(By.xpath("//form[@id=\"userListForm\"]//a[@id=\"adduser\"]"));
								  if(ths == null) {
										driver.close();     
									}else {
										ths.click();
									}
							  }
							
							 Thread.sleep(10000);
							 driver.switchTo().defaultContent();
							 System.out.println(driver.getWindowHandles());
							 
							 WebElement ele = driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]"));
							 
							 //WebElement ele = driver.findElement(By.xpath("//form[@id=\"userListForm\"]//a[@id=\"adduser\"]"));
							 driver.switchTo().frame(ele);
						    driver.findElement(By.id("user.USERNAME")).sendKeys(m.getValue().get(0));
							driver.findElement(By.id("user.EMAIL")).sendKeys(m.getValue().get(1));
							driver.findElement(By.id("user.MOBILE")).sendKeys(m.getValue().get(2));
							driver.findElement(By.id("user.PASSWORD")).sendKeys(m.getValue().get(3));
							Thread.sleep(5000);
							//状态
							WebElement Option= driver.findElement(By.xpath("//select[@id=\"user.ENABLE\"]"));
							System.out.println( ""+ "```===="+Option);
							String op = "//select[@id=\"user.ENABLE\"]/following-sibling::div[1]/dl/dd[@lay-value=\"";
							WebElement adrOption=driver.findElement(By.xpath(op+m.getValue().get(4) +"\"]")); 
							//WebElement adrOption=driver.findElement(By.xpath("//select[@id=\"user.ENABLE\"]/following-sibling::div[1]/dl/dd[@lay-value=\"1\"]"));  
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", adrOption);
							
							//用户类型 
							String type= "//select[@id=\"user.USERTYPE\"]/following-sibling::div[1]/dl/dd[@lay-value=\"";
							WebElement usertype=driver.findElement(By.xpath(type+m.getValue().get(5)+"\"]"));  
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", usertype);
							driver.findElement(By.id("user.REALNAME")).sendKeys(m.getValue().get(6));
							
							//driver.findElement(By.id("user.BIRTHDAY")).sendKeys(m.getValue().get(7));
						    String	genderStr = "//select[@id=\"user.GENDER\"]/following-sibling::div[1]/dl/dd[@lay-value=\"";
							WebElement gender=driver.findElement(By.xpath( genderStr+m.getValue().get(8)+"\"]"));  
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", gender); 
							
							driver.findElement(By.id("user.IDENTIFY")).sendKeys(m.getValue().get(9));
							driver.switchTo().defaultContent();
							//点击保存
							driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]/../../div[@class=\"layui-layer-btn layui-layer-btn-\"]/a[@class=\"layui-layer-btn0\"]")).click();
							//driver.findElement(By.cssSelector("div.layui-layer layui-layer-iframe > div.layui-layer-btn.layui-layer-btn- > a.layui-layer-btn0")).click();
							System.out.println( " &&&&&&&&" +driver.getWindowHandles());
							//判断是否保存成功
							//尝试去找弹出框
							//获取Alert弹框对象；
							java.util.List<WebElement> list =	 driver.findElements(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]/../../following-sibling::div"));
							  if(list.size() != 0 && list.size() >2) {
								  try {
										driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]/../../following-sibling::div[3]"));
										
										String st=  driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]/../../following-sibling::div[3]//div[2]")).getText();
										System.out.println(st);
										//截图
										driver.switchTo().defaultContent();
										driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]/../../following-sibling::div[3]//div[3]/a")).click();;
										driver.switchTo().defaultContent();
										//点击取消  
										driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]/../..//div[3]//a[2]")).click();
										
										
									} catch (NoAlertPresentException e) {
										System.out.println("尝试操作的prompt弹出框未找到！");
										e.printStackTrace();
										break;
									} 
								  
							  }else {
								  //保存成功
								  driver.switchTo().defaultContent();
								//点击取消  
								  driver.findElement(By.xpath("//div[@class=\"layui-layer-btn layui-layer-btn-\"]/a[1]")).click();
							  }
							
					  }
					  
					}
				}
  }
 
  @BeforeMethod
  public void beforeMethod() { 
	  
  }
     
  @AfterMethod
  public void afterMethod() {
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
	 /* System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\72.0.3626.121\\chromedriver.exe");
	  driver = new ChromeDriver();
	*/
  }

  @AfterClass
  public void afterClass() {
	 /* driver.close();*/
  }

  @BeforeTest
  public void beforeTest() throws BiffException, IOException {
	  //初始化数据
	  map=ReadExcel.excel("E:\\workspace-sts-3.9.6.RELEASE\\mavenDemo\\test.xls","Sheet1");
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
