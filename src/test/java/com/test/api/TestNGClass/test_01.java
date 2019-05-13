package com.test.api.TestNGClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test_01 {
	 
	public static void main(String[] args) throws InterruptedException {
		//������
		  System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\72.0.3626.121\\chromedriver.exe");
		  WebDriver  driver = new ChromeDriver();
		  driver.get("http://192.168.139.196:8086/cdzx/admin/login");
		  System.out.println("=======  ������   =========\n");
		  
			//�ȴ�Ԫ�س���  
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")));
		    Thread.sleep(5000);
		    //�����ѯ�ؼ���
		    
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("Intasect_123");
			Thread.sleep(2000);
			//�����ѯ��ť
			//driver.findElement(By.id(PageConstant.BTNKEY)).click();
			driver.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div[1]/div[2]/div[3]/button")).click();
			
			//�ҵ��˵�
			//*[@id="LAY-system-side-menu"]/li[1]/a
			 Thread.sleep(5000);
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a")));
			driver.findElement(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a")).click();
			//������ҶƬ
			//*[@id="LAY-system-side-menu"]/li[1]/dl/dd[1]/a
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
			//driver.findElement(By.id("")).click();
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
		
	}
}