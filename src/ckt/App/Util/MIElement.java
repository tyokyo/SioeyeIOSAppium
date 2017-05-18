package ckt.App.Util;

import io.appium.java_client.MobileElement;

public class MIElement {
	@Override
	public String toString() {
		return "MIElement [mobileElement=" + mobileElement
				+ ", getAccessibilityContainer()="
				+ getAccessibilityContainer() + ", getAccessible()="
				+ getAccessible() + ", getEnabled()=" + getEnabled()
				+ ", getFrame()=" + getFrame() + ", getLabel()=" + getLabel()
				+ ", getName()=" + getName() + ", getRect()=" + getRect()
				+ ", getType()=" + getType() + ", getValue()=" + getValue()
				+ ", getVisible()=" + getVisible()
				+ ", getWdAccessibilityContainer()="
				+ getWdAccessibilityContainer() + ", getWdAccessible()="
				+ getWdAccessible() + ", getWdEnabled()=" + getWdEnabled()
				+ ", getWdFrame()=" + getWdFrame() + ", getWdLabel()="
				+ getWdLabel() + ", getWdName()=" + getWdName()
				+ ", getWdRect()=" + getWdRect() + ", getWdType()="
				+ getWdType() + ", getWdValue()=" + getWdValue()
				+ ", getWdVisible()=" + getWdVisible() + "]";
	}
	public MIElement(MobileElement mobileElement) {
		this.mobileElement = mobileElement;
	}
	private MobileElement mobileElement;
	private String getAtt(String name){
		return mobileElement.getAttribute(name)+"";
	}
	public MobileElement getMobileElement() {
		return mobileElement;
	}
	public String getAccessibilityContainer() {
		return getAtt("accessibilityContainer")+"";
	}
	public String getAccessible() {
		return getAtt("accessible")+"";
	}
	public String getEnabled() {
		return getAtt("enabled")+"";
	}
	public String getFrame() {
		return getAtt("frame")+"";
	}
	public String getLabel() {
		return getAtt("label")+"";
	}
	public String getName() {
		return getAtt("name")+"";
	}
	public String getRect() {
		return getAtt("rect")+"";
	}
	public String getType() {
		return getAtt("type")+"";
	}
	public String getValue() {
		return getAtt("value")+"";
	}
	public String getVisible() {
		return getAtt("visible")+"";
	}
	public String getWdAccessibilityContainer() {
		return getAtt("wdAccessibilityContainer")+"";
	}
	public String getWdAccessible() {
		return getAtt("wdAccessible")+"";
	}
	public String getWdEnabled() {
		return getAtt("wdEnabled")+"";
	}
	public String getWdFrame() {
		return getAtt("wdFrame")+"";
	}
	public String getWdLabel() {
		return getAtt("wdLabel")+"";
	}
	public String getWdName() {
		return getAtt("wdName")+"";
	}
	public String getWdRect() {
		return getAtt("wdRect")+"";
	}
	public String getWdType() {
		return getAtt("wdType")+"";
	}
	public String getWdValue() {
		return getAtt("wdValue")+"";
	}
	public String getWdVisible() {
		return getAtt("wdVisible")+"";
	}
}
