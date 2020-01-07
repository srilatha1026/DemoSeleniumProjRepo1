package com.ipivot.InsuranceCalculator.DataDrivenTests;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ipivot.InsuranceCalculator.PageObject.ChoosePriceOptionPage;
import com.ipivot.InsuranceCalculator.PageObject.FillInsurantDataPage;
import com.ipivot.InsuranceCalculator.PageObject.FillProductDataPage;
import com.ipivot.InsuranceCalculator.PageObject.FillVehicleDataPage;
import com.ipivot.InsuranceCalculator.TestBase.TestBaseClass;
import com.ipivot.InsuranceCalculator.Utilities.excelRead;

//@Listeners(com.ipivot.InsuranceCalculator.Utilities.ListenerClass.class) //this is one way of writing.the other method is to use it in testng_tes1.xml.
public class TestCase1 {
	
	//WebDriver driver;//doesnt required to be written here as we are going to get it from TestBaseClass
	TestBaseClass tb = new TestBaseClass();
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver; // defined over here so that the driver instance created here can be accessed even in the testcases and teardown methods
	FillVehicleDataPage vehData;
	FillInsurantDataPage insData;
	FillProductDataPage prodData;
	ChoosePriceOptionPage priceOption;
	
	//create logger class object
	Logger log = Logger.getLogger(TestCase1.class.getName());
	
	
	@BeforeClass
	//reports get initialised before any of the tests start to execute
	public void reportSetup() {
		//set up details for extent reports==>//give config where the report needs to be stored
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output\\ExtentReport.html");
		extent = new ExtentReports();//this is the main class in which all the methods required for reporting is defined
		extent.attachReporter(html);//attaching the report to it
		html.config().setDocumentTitle("Test Automation Report - Execution Report - Insurance Calculator Project");//report title is given
		 html.config().setReportName("Test Automation Report - Execution Report - Insurance Calculator Project");//report name is given
		 html.config().setTheme(Theme.DARK);//set the theme for the report
//		 log.info("Extent Report Setting is completed....");
	}
	
	@BeforeMethod
	public void TestSetUp() throws Exception {
		//this is used to launch and navigate to the reqd url
		//method is created in testbase class
		//therfore to access or call that specific method we need to create an object or instance of the class.we do it in the start of this coding.please refer to the beginning of first few lines
	//webDriver driver = tb.LaunchandNavigateBrowser(); is method specific and cant be used in test1() method or teardown() method
	  driver = tb.LaunchandNavigateBrowser();// returns webdriver so assigning it to driver instance created as webdriver driver = null;
	  vehData = new FillVehicleDataPage(driver); //to call the method() into the testcase from FillVehicleDataPage class 
	  insData = new FillInsurantDataPage(driver);
	  prodData = new FillProductDataPage(driver);
	  priceOption = new ChoosePriceOptionPage(driver);
	}
	
	@Test(dataProvider = "insuranceCalcData", enabled=false)
	public void Test1(Map mapData) {
		
		log.info("Test case execution is started");
		logger = extent.createTest("Test1");//common line to write in every test case which should be sent to reports
		//actual testcase gets executed
//		System.out.println("Test is executed...");
//		System.out.println(mapData);
		//enter actual vehicle data
		vehData.FillActualVehicleData(mapData);
		vehData.clickOnNextBtn();
		
		//enter insurant data
		insData.fillActualInsurantData(mapData);
		insData.clickOnNextButton();
		
		//enter product data
		prodData.fillActualProductData(mapData);
		prodData.clickOnNext();
		
		//verify priceOptions
		priceOption.verifySilverPriceOption(mapData.get("PriceValidation_Silver").toString());
		priceOption.verifyGoldPriceOption(mapData.get("PriceValidation_Gold").toString());
		priceOption.verifyPlatinumPriceOption(mapData.get("PriceValidation_Platinum").toString());
		priceOption.verifyUltimatePriceOption(mapData.get("PriceValidation_Ultimate").toString());
		if(mapData.get("SelectOption").toString().equalsIgnoreCase("Silver")) {
			priceOption.selectSilverPlan();
		}
		if(mapData.get("SelectOption").toString().equalsIgnoreCase("gold")) {
			priceOption.selectGoldPlan();
		}
		if(mapData.get("SelectOption").toString().equalsIgnoreCase("platinum")) {
			priceOption.selectPLatinumPlan();
		}
		if(mapData.get("SelectOption").toString().equalsIgnoreCase("ultimate")) {
			priceOption.selectUtimatePlan();
		}
		priceOption.clickOnNextButton();
		
	}
	
	@DataProvider(name="insuranceCalcData")
	public Object[][] dataProviderMethod() throws IOException {
		excelRead e = new excelRead();
		return e.ExcelDataInObjectArray();
	}
	
	//@AfterMethod is invoked after testcase1 is executed
	@Test(enabled = true)
	public void Test2() {
	//	log.info("Test Execution started");
		logger = extent.createTest("Test2");
		System.out.println("test case 2");
	//	log.info("Test Execution Finished");
		Assert.assertEquals("sss", "nnn");
		
	}
	//@AfterMethod is invoked after testcase2 is executed
	//so for every @test method is finished executing @Afetrmethod is invoked evrytime
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		 if(result.getStatus() == ITestResult.FAILURE){
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed.", ExtentColor.RED));
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Case Failed.", ExtentColor.RED));
		
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".jpeg";
		 FileUtils.copyFile(src, new File(screenshotPath));
		 logger.fail("Test Case is failed, Screenshot is attached. "+logger.addScreenCaptureFromPath(screenshotPath));
		 }
		 else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "- Test Case is SKipped.", ExtentColor.ORANGE));
		 }
		 else if(result.getStatus() == ITestResult.SUCCESS){
			 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "- Test Case is Passed.", ExtentColor.GREEN));
			 }
		 if(driver!= null) {
//			 driver.close();
//			 driver.quit();
			 
		 }
		 
	 }
	
	//after all the testcase is reported @afterclass is executed which closes the reports
	 @AfterClass
	 public void endReport(){
	     extent.flush(); //ends the report
			 
	}
}
