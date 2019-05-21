package com.test.data;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.test.api.TestNGClass.IdAuth;

/*import data.search;
import se_2018.ctrip_06_04;*/

public class function {

	static Logger logger = Logger.getLogger(IdAuth.class);
	public static void Search(WebDriver driver,String leave,String arrive,int num){
		logger.info("出发地");
		Search.SearchLeave(driver).sendKeys(leave);
		logger.info("到达地");
		Search.SearchArrive(driver).sendKeys(arrive);
		   
		Search.js(driver);
		Search.SearchDate(driver).clear();
		Search.SearchDate(driver).sendKeys(Search.NextDay(num));
		logger.info("车次查询");
		Search.SearchInner(driver).click();
		Search.SearchBtn(driver).click();
		   	   
	   }

	/*public static void Train_no(WebDriver driver,String no){
		search.train_no(driver, no).click();
	}*/
	/*
	 * 返回path
	 */
	public static String ProPath(){
		return  System.getProperty("user.dir");
	}


}
