package Analyzer;

import Jira.JiraCreateIssue;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer , ITestListener {

    private int counter = 0;
    private static int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (counter < maxTry) {                            //Check if maxtry count is reached
                counter++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);    //Mark test as failed
                JiraCreateIssue.jiraTestFailure(iTestResult);
                return true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}
