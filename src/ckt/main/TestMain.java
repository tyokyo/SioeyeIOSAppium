package ckt.main;

import org.openqa.selenium.By;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.inspector.CutXml;

public class TestMain extends VP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startAppium();
		CutXml.repXml(iosdriver.getPageSource().replaceAll("\n", ""));
		Draw.takeScreenShot();
		iosdriver.findElement(By.name("我")).click();
		stopAppium();
	}

}
