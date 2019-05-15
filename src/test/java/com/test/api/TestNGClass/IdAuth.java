package com.test.api.TestNGClass;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 // @Test(dataProvider="dp")
  public void w(Integer n, String s) throws Exception {
	  System.out.println("n is "+n);
	  System.out.println("s is "+s);
	  Assert.assertEquals(Integer.valueOf(2), n);
  }
  @Test(description = "�ٶ�����")
  public void baiduSearchTest() throws Exception {
      String url = "http://www.baidu.com";
      System.out.println("url:"+url);
      driver.get(url);
      driver.findElement(By.id("kw")).sendKeys("galen2016");
      driver.findElement(By.id("s11")).click();
  }

  @Test(description = "�ѹ�����")
  public void sougouSearchTest(){
      driver.get("https://www.sogou.com");
      driver.findElement(By.id("query1")).sendKeys("galen2016");
  }
  
  @Test(description = "����������Ա")
  @Step("��cdzx��½ҳ��ʵ����ǲ���")
  @Description("����allure report")
  public void f() throws Exception  {
	  //������
	 /* System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\72.0.3626.121\\chromedriver.exe");*/
	  driver.get("http://192.168.139.196:8086/cdzx/admin/login");
	  
		//�ȴ�Ԫ�س���  
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")));
	    Thread.sleep(5000);
	    //�����ѯ�ؼ���
	    
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Intasect_123");
		Thread.sleep(2000);
		//�����ѯ��ť
		driver.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")).click();
		
		//�ҵ��˵�
		 Thread.sleep(5000);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a")));
		driver.findElement(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a")).click();
		//������ҶƬ
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/dl/dd[1]/a")));
		driver.findElement(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/dl/dd[1]/a")).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"LAY_app_body\"]/div[2]/iframe")));
		
		WebElement ths= driver.findElement(By.id("adduser"));
		if(ths == null) {
			driver.close();     
		}else {
			ths.click();
		}
		 Thread.sleep(10000);
		 driver.switchTo().defaultContent();
		 String parentWindowHandler = driver.getWindowHandle();
		 String subWindowHandler = null;
		 //driver.switchTo().frame(0);
		 System.out.println(driver.getWindowHandles());
		 
		 WebElement ele = driver.findElement(By.xpath("//iframe[@src=\"/cdzx/security/user/add/\"]"));
		 driver.switchTo().frame(ele);
		/* Set<String> handles = driver.getWindowHandles()	;
		 for (String windowHandle : handles) {
		      subWindowHandler = windowHandle;
		 }*/
		/* if(subWindowHandler != null && !subWindowHandler.equals(parentWindowHandler)){
			 driver.switchTo().window(subWindowHandler);
		     driver.close();
		     driver.switchTo().window(parentWindowHandler);
		 }*/
		 
		 /*(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layui-layer1\"]")));*/
		//���水ť
		//*[@id="layui-layer1"]/div[3]/a[1]
		/*(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")));
		driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")).click();
		*/
		//��ֵ
		 
		driver.findElement(By.id("user.USERNAME")).sendKeys("zhangsan1");
		driver.findElement(By.id("user.EMAIL")).sendKeys("471255559@qq.com");
		driver.findElement(By.id("user.MOBILE")).sendKeys("18482176779");
		driver.findElement(By.id("user.PASSWORD")).sendKeys("admin");
		//״̬
		WebElement adrOption=driver.findElement(By.xpath("//select[@id=\"user.ENABLE\"]/following-sibling::div[1]/dl/dd[@lay-value=\"1\"]"));  
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", adrOption);
		
		//�û����� 
		WebElement usertype=driver.findElement(By.xpath("//select[@id=\"user.USERTYPE\"]/following-sibling::div[1]/dl/dd[@lay-value=\"1\"]"));  
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", usertype);
		//driver.findElement(By.id("user.ENABLE")).sendKeys("����");//״̬
		//driver.findElement(By.id("user.USERTYPE")).sendKeys("����Ա");//�û�����
		driver.findElement(By.id("user.REALNAME")).sendKeys("ʮ��");
		//driver.findElement(By.id("user.BIRTHDAY")).sendKeys("0816");
		WebElement gender=driver.findElement(By.xpath("//select[@id=\"user.GENDER\"]/following-sibling::div[1]/dl/dd[@lay-value=\"1\"]"));  
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", gender); 
		
		driver.findElement(By.id("user.IDENTIFY")).sendKeys("513030199908440222");
		driver.switchTo().defaultContent();
		//�������
		driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")).click();
		Thread.sleep(5000);
		//�ж��Ƿ񱣴�ɹ�
		
		
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
  public void beforeTest() {
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
