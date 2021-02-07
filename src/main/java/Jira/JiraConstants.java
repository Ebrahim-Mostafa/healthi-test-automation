package Jira;

import static Utilities.LoadProperties.jiraProperty;

public class JiraConstants {

    public static final String JIRA_URL = jiraProperty.getProperty("JiraURL");
    public static final String JIRA_USERNAME = jiraProperty.getProperty("JiraUsername");
    public static final String JIRA_PASSWORD = jiraProperty.getProperty("JiraPassword");
    public static final String PROJECT_KEY = jiraProperty.getProperty("ProjectKey");
    public static final String ISSUE_TYPE = jiraProperty.getProperty("IssueType");
}
