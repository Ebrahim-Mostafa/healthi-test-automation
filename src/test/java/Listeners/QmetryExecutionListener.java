package Listeners;

import Qmetry.UploadToCloud;
import Qmetry.UploadToServer;
import org.apache.commons.httpclient.auth.InvalidCredentialsException;
import org.testng.IExecutionListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.Properties;

import static Qmetry.QmetryConstants.*;
import static Utilities.Utils.fileLocation;


public class QmetryExecutionListener implements IExecutionListener {


    public boolean isEnabled() {
//         get configuration values from pom
        return p.getProperty(INTEGRATION_EANBLED).equalsIgnoreCase("true");
//        QmetryTestCase qmetryTC = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(QmetryTestCase.class);
//        boolean isTicketReady = qmetryTC.logTicketReady();
    }

    @Override
    public void onExecutionFinish() {

        // If integration not enabled then return
        if (!isEnabled()) {
            System.out.println("QTM4J integration is disabled !!!");
            return;
        }

        if (p.getProperty(API_TYPE).toUpperCase().contains("S")) {
            //code for server API
            System.out.println("Jira Hosting type : On Premise");
            try {
                UploadToServer.uploadToTheServer(p.getProperty(API_KEY), p.getProperty(API_URL), p.getProperty(PASSWORD), p.getProperty(TEST_RUN_NAME), p.getProperty(LABELS),
                        p.getProperty(SPRINT),  p.getProperty(VERSION), p.getProperty(COMPONENTS), p.getProperty(USERNAME), FILE_PATH, p.getProperty(PLATFORM), p.getProperty(COMMENT));
            } catch (InvalidCredentialsException e) {

                e.printStackTrace();
            } catch (ProtocolException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

        } else {
            // code for connect API
            System.out.println("Jira Hosting type : Cloud");
            try {
                UploadToCloud.uploadToTheCloud(p.getProperty(API_KEY), p.getProperty(API_URL),
                        FILE_PATH,
                        p.getProperty(TEST_RUN_NAME), p.getProperty(LABELS), p.getProperty(SPRINT), p.getProperty(VERSION),
                        p.getProperty(COMPONENTS), p.getProperty(PLATFORM), p.getProperty(COMMENT));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onExecutionStart() {

        try {
            System.out.println("Test Run Started");
//            InputStream is = new FileInputStream(System.getProperty("user.dir") +
//                    File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "qmetry.properties");
            fileLocation =  System.getProperty("user.dir") + File.separator + "qmetry.properties";
            InputStream is = new FileInputStream(fileLocation);
            p = new Properties();
            p.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
