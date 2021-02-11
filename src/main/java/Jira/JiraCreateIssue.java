package Jira;

import com.sun.jersey.core.util.Base64;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.ITestResult;

import java.io.IOException;

import static Jira.JiraConstants.*;

public class JiraCreateIssue {

    public static void jiraTestFailure(ITestResult result) {

        JiraTestCase jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraTestCase.class);
        boolean isTicketReady = jiraPolicy.logTicketReady();
        if (isTicketReady) {
            try {
                String auth = new String(Base64.encode(JIRA_USERNAME + ":" + JIRA_PASSWORD));

                CloseableHttpClient client = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost(JiraConstants.JIRA_URL);
                httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + auth);
                httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");
                String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()
                        + " got failed due to some assertion or exception";
                String issueDescription = result.getThrowable().getMessage();
                issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
                String body = "{\"fields\":{\"project\":{\"key\":\"" + PROJECT_KEY + "\"},\"summary\":\"" + issueSummary + "\",\"description\":\"" + issueDescription + "\",\"issuetype\":{\"name\":\"" + ISSUE_TYPE + "\"}}}";
                StringEntity entity = new StringEntity(body);
                httpPost.setEntity(entity);

                HttpResponse response = client.execute(httpPost);
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(response.getEntity());

                System.out.println("Body: " + responseBody);

                System.out.println("Status Code: " + statusCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
