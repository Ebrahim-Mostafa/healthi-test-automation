package Listeners;


import Recorders.ATUTestRecord;
import Utilities.Utils;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        try {
            Utils.takeAScreenshot(testResult.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ATUTestRecord.startScreenRecorder(testResult.getName());
        } catch (ATUTestRecorderException e) {
            e.printStackTrace();
        }

        try {
            ATUTestRecord.stopScreenRecorder();
        } catch (ATUTestRecorderException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onFinish(ITestContext context) {
    }

}

