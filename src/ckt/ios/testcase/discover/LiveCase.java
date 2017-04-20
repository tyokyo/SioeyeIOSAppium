package ckt.ios.testcase.discover;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ckt.App.Util.VP4;
import ckt.ios.page.DiscoverPage;

public class LiveCase extends VP4 {
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
    
	@AfterClass
	public void afterClass() {
		stopAppium();
	}	
	@Test
	public void testWatchLoveVideo(){
		DiscoverPage.getCell();
	}
}
