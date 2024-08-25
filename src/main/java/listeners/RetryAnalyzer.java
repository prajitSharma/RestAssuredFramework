package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            //ExtentReportListener.test.get().log(Status.WARNING, "Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time.");
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if(status == 1)
            resultName = "SUCCESS";
        if(status == 2)
            resultName = "FAILURE";
        if(status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
