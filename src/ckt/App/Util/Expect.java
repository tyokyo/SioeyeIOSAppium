package ckt.App.Util;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Expect extends VP4
{
	private static final Logger log = Logger.getLogger(Expect.class.getName());

	public static boolean titleIs(String title)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.titleIs(title));
	}
	public static boolean titleContains(String title)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	public static boolean urlToBe(String url)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	public static boolean  urlContains(String fraction)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.urlContains(fraction));
	}
	public static boolean urlMatches(String regex)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.urlMatches(regex));
	}
	public static boolean presenceOfElementLocated(By locator)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null;
	}
	private static WebElement elementIfVisible(WebElement element)
	{
		return element.isDisplayed() ? element : null;
	}
	public static boolean textToBePresentInElement(WebElement element, final String text)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElement(element,text)) ;
	}
	public static boolean textToBePresentInElementLocated(By locator, final String text)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text)) ;
	}
	public static boolean textToBePresentInElementValue(WebElement element, final String text)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElementValue(element,text));
	}

	public static boolean textToBePresentInElementValue(By locator, final String text)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElementValue(locator,text));
	}
	public static boolean invisibilityOfElementLocated(By locator)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static boolean invisibilityOfElementWithText(By locator, final String text)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.invisibilityOfElementWithText(locator,text));
	}
	public static Alert alertIsPresent()
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	private static WebElement findElement(By by, WebDriver driver)
	{
		try
		{
			return driver.findElement(by);
		} catch (NoSuchElementException e) {
			throw e;
		} catch (WebDriverException e) {
			log.log(Level.WARNING, 
					String.format("WebDriverException thrown by findElement(%s)", new Object[] { by }), 
					e);
			throw e;
		}
	}
	private static List<WebElement> findElements(By by, WebDriver driver)
	{
		try
		{
			return driver.findElements(by);
		} catch (WebDriverException e) {
			log.log(Level.WARNING, 
					String.format("WebDriverException thrown by findElement(%s)", new Object[] { by }), 
					e);
			throw e;
		}
	}
	public static boolean attributeToBe(By locator, final String attribute, final String value)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.attributeToBe(locator,attribute,value)) ;
	}
	public static boolean textToBe(By locator, final String value)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.textToBe(locator,value)) ;
	}
	public static boolean textMatches(By locator, final Pattern pattern)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.textMatches(locator,pattern)) ;
	}
	public static List<WebElement> numberOfElementsToBeMoreThan(By locator, final Integer number)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,number)) ;
	}
	public static List<WebElement> numberOfElementsToBeLessThan(By locator, final Integer number)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator,number)) ;
	}
	public static List<WebElement> numberOfElementsToBe(By locator, final Integer number)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.numberOfElementsToBe(locator,number)) ;
	}
	public static boolean attributeToBe(WebElement element, final String attribute, final String value)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.attributeToBe(element,attribute,value)) ;
	}
	public static boolean attributeContains(WebElement element, final String attribute, final String value)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.attributeContains(element,attribute,value)) ;
	}
	public static boolean attributeContains(By locator, final String attribute, final String value)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.attributeContains(locator,attribute,value)) ;
	}
	public static boolean attributeToBeNotEmpty(WebElement element, final String attribute)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element,attribute)) ;
	}
	public static List<WebElement> visibilityOfNestedElementsLocatedBy(By locator, final By sub_locator)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(locator,sub_locator)) ;
	}
	public static List<WebElement> visibilityOfNestedElementsLocatedBy(WebElement element, final By sub_locator)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element,sub_locator)) ;
	}
	public static boolean presenceOfNestedElementLocatedBy(By locator, final By sub_locator)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator,sub_locator)) != null ;
	}
	public static boolean presenceOfNestedElementLocatedBy(WebElement element, final By sub_locator)
	{
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element,sub_locator)) != null ;
	}
}