package com.test.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {

	/*
	 * ������
	 */
	public static WebElement SearchLeave(WebDriver driver){
		return driver.findElement(By.id("notice01"));
	}
	/*
	 * �����
	 */
	public static WebElement SearchArrive(WebDriver driver){
		return driver.findElement(By.id("notice08"));
	}
	
	/*
	 * ����δ��������
	 */
    public  static String NextDay(int num){
    	Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		String  Day = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(Day);
		return Day;
    }
    /*
     * jsִ������
     */
    public static void  js(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("var LeaveDate = document.getElementById('dateObj'); 	LeaveDate.removeAttribute('readonly');");
	}
    
    /*
     * ����
     */
    public static WebElement SearchDate(WebDriver driver){
		return driver.findElement(By.id("dateObj"));
	}
    /*
     * ���ڻ�Ʊ
     * 
     */
    public static WebElement SearchInner(WebDriver driver){
    	return driver.findElement(By.cssSelector("#searchtype > li.current"));
    }
    /*
     * ��ѯ
     */
    public static WebElement SearchBtn(WebDriver driver){
		return driver.findElement(By.id("searchbtn"));
	}
    
    /*
     * Ԥ������
     */
    public static WebElement  train_no(WebDriver driver,String no){
		return driver.findElement(By.xpath("//div[starts-with(@id,'tbody-01-"+no+"')]/div[1]/div[6]/div[1]/a"));
	}

}
