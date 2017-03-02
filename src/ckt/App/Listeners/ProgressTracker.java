package ckt.App.Listeners;

import java.util.Calendar;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ProgressTracker implements IInvokedMethodListener {

	private long startTime = 0;
	private int totalExecuted = 0;
	public static int totalRun = 0;

	@Override
	public void afterInvocation(IInvokedMethod invokedMethod,
			ITestResult testResult) {
		if (invokedMethod.isTestMethod()) {
			ITestNGMethod m = invokedMethod.getTestMethod();
			String methodName = m.getConstructorOrMethod().getName();
			String className = m.getTestClass().getRealClass().getSimpleName();

			int status = testResult.getStatus();
			String statusText = "Unknown";
			switch (status) {
			case ITestResult.FAILURE:
				statusText = "Failed";
				break;
			case ITestResult.SUCCESS:
				statusText = "Passed";
				break;
			case ITestResult.SKIP:
				statusText = "Skipped";
				break;
			}

			long elapsedTime = (Calendar.getInstance().getTimeInMillis() - startTime) / 1000;
			int remainingTestCount = totalRun - totalExecuted;
			long remainingTime = (elapsedTime / totalExecuted)
					* remainingTestCount;
			System.out.println("[Progress]"
					+ formPercentageStr(totalExecuted, totalRun) + " ("
					+ totalExecuted + "/" + totalRun + ") " + ", Elapsed:"
					+ formTimeStr(elapsedTime) + ", Estimated Time Remaining:"
					+ formTimeStr(remainingTime));

			System.out.println("[End] " + methodName + "(" + className + "): "
					+ statusText + "\n");

		}
	}

	@Override
	public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult arg1) {
		if (invokedMethod.isTestMethod()) {
			ITestNGMethod m = invokedMethod.getTestMethod();
			String methodName = m.getConstructorOrMethod().getName();
			String className = m.getTestClass().getRealClass().getSimpleName();
			System.out
					.println("[Begin] " + methodName + "(" + className + ") ");
			if (startTime == 0) {
				startTime = Calendar.getInstance().getTimeInMillis();
			}
			totalExecuted += 1;
		}
	}

	private String formPercentageStr(long executedTestCount, long totalTestCount) {
		return Math.round((double) executedTestCount * 100
				/ (double) totalTestCount)
				+ "%";
	}

	private String formTimeStr(long valueInSeconds) {
		long hours = valueInSeconds / 3600;
		valueInSeconds = valueInSeconds % 3600;

		long minutes = valueInSeconds / 60;
		valueInSeconds = valueInSeconds % 60;

		return toTwoDigitsStr(hours) + ":" + toTwoDigitsStr(minutes) + ":"
				+ toTwoDigitsStr(valueInSeconds);
	}

	private String toTwoDigitsStr(long value) {
		if (value < 10) {
			return "0" + value;
		} else {
			return String.valueOf(value);
		}
	}
}
