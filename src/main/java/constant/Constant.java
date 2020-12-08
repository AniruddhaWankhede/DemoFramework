package constant;

import org.apache.log4j.Logger;

public class Constant {
	public static final String repoPanelXpath = "//div[@id='org-repositories']//ul//li//div[contains(@class,'flex-auto')]";
	public static Logger logger = Logger.getLogger("ThreadLogger: ");
	public static final String configPropertiesPath = "config.properties";
	public static final String chromeBrowser = "Google Chrome";
	public static final String ieBrowser = "Internet Explorer";
	public static final String extentReportFilePath = "/build/ExecutionReport.html";
	public static final String logsFileDir = "/build/logs/";
	public static final String logsFileName = "threadLog.txt";
	public static final String screenshotFileDir = "/build/screenshots/";
	public static final String screenshotFileName = "screenshot.jpg";
	public static final String firefoxBrowser = "Firefox";
	public static final String repositoriesPageTitle = "Django · GitHub";
	public static final String packagesPageTitle = "Packages · Django";
	public static final String peoplePageTitle = "People · Django";
	public static final String projectsPageTitle = "Projects · django";
	public static final String repositoriesPage = "Repositories";
	public static final String packagesPage = "Packages";
	public static final String peoplePage = "People";
	public static final String projectsPage = "Projects";
	public static final int httpStatusCodeOK = 200;
	public static final int httpStatusCodeCREATED = 201;
	public static final int httpStatusCodeACCEPTED = 202;
	public static final int httpStatusCodeBADREQUEST = 400;
	public static final int httpStatusCodeUNAUTHORIZED = 401;
	public static final int httpStatusCodeFORBIDDEN = 403;
	public static final int httpStatusCodePAGENOTFOUND = 404;
	public static final int httpStatusCodeMETHODNOTALLOWED = 405;
	public static final int httpStatusCodeSERVERERROR = 500;
	public static final int httpStatusCodeBADGATEWAY = 502;
	public static final int httpStatusCodeGATEWAYTIMEDOUT = 504;
}

