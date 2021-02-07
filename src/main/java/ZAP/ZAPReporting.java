package ZAP;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import static BasePackage.BaseTest.driver;
import static Loggers.Log4JLogger.logger;
import static Utilities.LoadProperties.zapProperty;
import static Utilities.Utils.*;

public class ZAPReporting {

    public  final static String ZAP_HOST = zapProperty.getProperty("ZAPProxyHost");
    public  final static int ZAP_PORT = 8080;
    private final static String BASE_URL = zapProperty.getProperty("BaseURL");
    // create an object of org.zaproxy.clientapi.core.ClientApi using ZAP host and port.
    private static ClientApi api = new ClientApi(ZAP_HOST, ZAP_PORT);

    // function to wait for passive scan to complete
    public static void waitForPassiveScanToComplete() {

        logger.info("--- Waiting for passive scan to complete --- ");
        try {
            api.pscan.enableAllScanners("true"); // enable passive scanner.
            // getting a response
            ApiResponse response = api.pscan.recordsToScan();
            //iterating till we get response as "0".
            while (!response.toString().equals("0")) {
                response = api.pscan.recordsToScan();
            }
        } catch (ClientApiException e) {
            e.printStackTrace();
        }
        logger.info("--- Passive scan completed! ---");
    }

    public static void startActiveScan() {

        logger.info("Active scan : " + driver.getCurrentUrl());
        try {
            // initiate the active scan -  refer doc to underatand the  constructor parameters.
            ApiResponse resp = api.ascan.scan(BASE_URL, "True", "False", null, null, null, null);
            int progress;

            // scan response will return the scan id to support concurrent scanning.
            String scanid = ((ApiResponseElement) resp).getValue();
            // Polling the status of scan until it completes
            while (true) {
                Thread.sleep(5000);
                progress = Integer.parseInt(((ApiResponseElement)
                        api.ascan.status(scanid)).getValue());
                System.out.println("Active Scan progress : " + progress + "%");
                if (progress >= 100) {
                    break;
                }
            }
            System.out.println("Active Scan complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example code to start and synchronize the spider scan.
    public static void startSpiderScan() {

        logger.info("Spider : " + driver.getCurrentUrl());
        try {
            // Start the spider scan - refer the documentation of ZAP  APIs to understand the spider scan
            ApiResponse resp = api.spider.scan("spider", "action", "scan", null);
            int progress;
            // scan response will return the scan id to support concurrent scanning.

            String scanid = ((ApiResponseElement) resp).getValue();
            // Polling the status until it completes
            while (true) {
                Thread.sleep(1000);
                progress = Integer.parseInt(((ApiResponseElement) api.spider.status(scanid)).getValue());
                System.out.println("Spider progress : " + progress + "%");
                if (progress >= 100) {
                    break;
                }
            }
            System.out.println("Spider complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getReports() {

        try {
            // calling core apis to get html report in bytes.
            byte[] bytes = api.core.htmlreport("true");

            // getting the alert messages and just printing those.
            ApiResponse messages = api.core.messages(BASE_URL, "0", "99999999");
            System.out.println(messages);

            // storing the bytes in to html report.
            String str = new String(bytes, StandardCharsets.UTF_8);
            fileInfo = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
            fileLocation = System.getProperty("user.dir") + "/logs";
            fileName = "OWASP ZAP Report";
            File newTextFile = new File(fileLocation + File.separator + fileName + "-" + fileInfo + ".html");
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}