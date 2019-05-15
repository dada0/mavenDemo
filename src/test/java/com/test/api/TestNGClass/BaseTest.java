package com.test.api.TestNGClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Listeners({TestFailListener.class})
public class BaseTest {

	public WebDriver driver;

    public WebDriver getDriver(){
    	
        return driver;
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\72.0.3626.121\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
