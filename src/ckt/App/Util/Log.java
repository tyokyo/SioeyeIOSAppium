package ckt.App.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.testng.Reporter;

/** Simple logger interface. */
public class Log {
	private static Logger logger = Logger.getLogger(Log.class.getName());
	private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
		@Override protected DateFormat initialValue() {
			return new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
		}
	};
	public static void warn(String message, Object... args) {
		//logger.warning(getPrefix() + String.format(message, args));
		//System.out.println(getPrefix() + String.format(message, args));
		//logger.info(getPrefix() + String.format(message, args));
	    Reporter.log(getPrefix()+String.format(message, args)+"<br>");
	}
	public static void info(String message, Object... args) {
		String messages = getPrefix()+String.format(message, args);
		logger.info(messages);
		//System.out.println(getPrefix() + String.format(message, args));
		Reporter.log(messages+"<br>");
	}

	private static String getPrefix() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace == null || stackTrace.length < 4) return "[BOGUS]";
		String className = stackTrace[3].getClassName();
		String methodName = stackTrace[3].getMethodName();
		className = className.replaceAll("[a-z\\.]", "");
		String timestamp = DATE_FORMAT.get().format(new Date());
		return String.format("%s [%s.%s] ", timestamp, className, methodName);
	}

}
