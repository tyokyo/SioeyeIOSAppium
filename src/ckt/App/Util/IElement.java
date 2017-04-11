package ckt.App.Util;

import java.awt.Rectangle;
import java.util.Vector;

public class IElement {
	public Vector add(Vector vData){
		Vector vRow1 = new Vector();
		vRow1.add("name");
		vRow1.add(getName());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("value");
		vRow1.add(getValue());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("label");
		vRow1.add(getLabel());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("visible");
		vRow1.add(getVisible());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("enabled");
		vRow1.add(getEnabled());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("x");
		vRow1.add(getX());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("y");
		vRow1.add(getY());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("width");
		vRow1.add(getWidth());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("height");
		vRow1.add(getHeight());
		vData.add(vRow1);
		
		vRow1 = new Vector();
		vRow1.add("xpath");
		vRow1.add(getXpath());
		vData.add(vRow1);
		
		
		return vData;
	}
		@Override
	public String toString() {
		return "IElement [className=" + className + ", name=" + name
				+ ", label=" + label + ", value=" + value + ", enabled="
				+ enabled + ", visible=" + visible + ", xpath=" + xpath
				+ ", x=" + x + ", y=" + y + ", width=" + width + ", height="
				+ height + "]";
	}
		private String className;
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getEnabled() {
			return enabled;
		}
		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}
		public String getVisible() {
			return visible;
		}
		public void setVisible(String visible) {
			this.visible = visible;
		}
		public String getXpath() {
			return xpath;
		}
		public void setXpath(String xpath) {
			this.xpath = xpath;
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		public double getWidth() {
			return width;
		}
		public void setWidth(double width) {
			this.width = width;
		}
		public double getHeight() {
			return height;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		
		private String name;
		private String label;
		private String value;
		private String enabled;
		private String visible;
		private String xpath;
		private double x;
		private double y;
		private double width;
		private double height;
		private Rectangle rectangle;
		
		public double getArea() {
			return this.width*this.height;
		}
		public Rectangle getRectangle() {
			rectangle=new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.height);
			return rectangle;
		}
		
		
}
