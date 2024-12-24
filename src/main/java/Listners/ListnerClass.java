package Listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sun.tools.sjavac.Log;

import org.apache.log4j.Logger;

import Utility.LogsUtility;

public class ListnerClass implements ITestListener{
	public static Logger log = LogsUtility.getLogger(ListnerClass.class);
	
	@Override
	public void onTestFailure(ITestResult result) {
		log.info("get the failed message");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Hurray!! Testcase Passed ");
	}
	@Override
	public void onTestSkipped(ITestResult result) {

	}

}
