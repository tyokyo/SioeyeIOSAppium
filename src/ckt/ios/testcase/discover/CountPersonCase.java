package ckt.ios.testcase.discover;

import org.openqa.selenium.By;
import org.testng.Assert;

import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.page.DiscoverPage;

/**
 * Created by caibing.yin on 2016/11/7.
 */
public class CountPersonCase extends VP4 {
	/**
	 * case10:
	 *历史观看人数统计
	 *1.反复进入退出视频播放界面后回到封面检查历史观看人数
	 *  Result：每次进入播放视频界面后退出视频封面界面，历史观看人数加1
	 * */
	public void testCountWatchPerson() {
		for (int i = 0; i < 5; i++) {
			IElement cellEem = DiscoverPage.getCell();
			String beforeString=DiscoverPage.getWatchCount(cellEem.getXpath());
			log(beforeString);
			int beforeWatch = DiscoverPage.kToInt(beforeString);
			
			cellEem.click();
			wait(6);
			waitUntilGone(30,By.className("ActivityIndicator"));

			DiscoverPage.watchBack();
			
			String afterString=DiscoverPage.getWatchCount(cellEem.getXpath());
			log(beforeString);
			int afterWatch = DiscoverPage.kToInt(afterString);
			if (beforeWatch<1000) {
				Assert.assertEquals(afterWatch, beforeWatch+1,"watch video");
			}
		}
	}
}
