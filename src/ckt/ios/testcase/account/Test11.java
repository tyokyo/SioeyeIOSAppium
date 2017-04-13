package ckt.ios.testcase.account;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ckt.App.Util.VP4;

public class Test11 extends VP4 {
	@BeforeMethod
	public void beforeTest(){
		System.out.println("@BeforeMethod");
	}
    
	@AfterMethod
	public void afterTest() {
		System.out.println("@AfterMethod");
	}
	
	@Test
	public void testError1(){
		System.out.println("testError1");
	}
	@Test
	public void testError2(){
		System.out.println("testError2");
	}
}
