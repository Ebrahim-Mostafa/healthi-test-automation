package Jira;

import static Utilities.LoadProperties.jiraProperty;

public class JiraConstants {

    public static final String JIRA_URL = jiraProperty.getProperty("URL");
    public static final String JIRA_USERNAME = jiraProperty.getProperty("Username");
    public static final String JIRA_PASSWORD = jiraProperty.getProperty("Password");
    public static final String PROJECT_KEY = jiraProperty.getProperty("Key");
    public static final String ISSUE_TYPE = jiraProperty.getProperty("Type");
}
