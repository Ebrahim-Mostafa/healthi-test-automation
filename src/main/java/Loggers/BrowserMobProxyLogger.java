package Loggers;


import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.Proxy;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static BasePackage.BrowserOptions.proxyServer;
import static Utilities.Utils.*;


public class BrowserMobProxyLogger {

    public static BrowserMobProxy getProxyServer() {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start();
        return proxy;
    }

    public static Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Assert.fail("invalid Host Address");
        }
        return seleniumProxy;
    }

    public static void printBrowserMobProxyResults() throws IOException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Har har = proxyServer.getHar();
        fileInfo = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
        fileLocation = System.getProperty("user.dir") + "/logs";
        fileName = "healthi-test";
        File harFile = new File(fileLocation + File.separator + fileName + "-" + fileInfo + ".json");
        //  File harFile = new File("healthi-test.har");
        har.writeTo(harFile);
        List<HarEntry> entries = proxyServer.getHar().getLog().getEntries();
        for (HarEntry entry : entries) {
            System.out.println("URL " + entry.getRequest().getUrl());
            System.out.println("Response Code " + entry.getResponse().getStatus());
        }
    }

    /*  public static void BrowserMobProxyLogger() {
        proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Assert.fail("invalid Host Address");
        }
    }*/
}
