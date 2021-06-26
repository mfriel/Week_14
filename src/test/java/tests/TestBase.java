package tests;

import core.ExcelDataProvider;
import core.ITestData;
import core.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import core.DriverFactory1;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class TestBase {
	
	private WebDriver driver;
	private ITestData testData;

	@Parameters({"env"})
	@BeforeSuite
	public void initSuite(String env) throws Exception {
		TestConfig.load(env);
	}

	@Parameters({"browser"})
	@BeforeClass
	public void initDriver(String browser) {
		System.out.println(browser);
		driver =  new DriverFactory1().getDriver(browser);
	}

	//this will get the data from the excel file.
	@Parameters({"dataSource"})
	@BeforeMethod
	public Object[][] getData(Method testCase, String dataSource) throws Exception {
		File testDataLocation = new File("src/test/resources/testdata");

		// Setting the data source
		if(dataSource.equalsIgnoreCase("excel")){
			String sheetName  =  System.getenv("env").toUpperCase(); //is the env name and also the excel sheet/tab name
			this.testData = new ExcelDataProvider(testDataLocation.getAbsolutePath()+"/TestData.xlsx",sheetName);

			ExcelDataProvider excel = new ExcelDataProvider(testDataLocation.getAbsolutePath()+"/TestData.xlsx",sheetName);
			excel.getTestData("", "");


//			List<HashMap<String,String>> extractedData = this.testData.getAllData(testCase.getName());
//			return this.createDataProvider(extractedData);
		}else if(dataSource.equalsIgnoreCase("json")){

		}else{
			throw new Exception("Invalid data source specified : "+dataSource);
		}
		return null;
	}

	private Object[][] createDataProvider(List<HashMap<String,String>> dataSet){
		int rowNo = dataSet.size();
		Object[][] dataArray = new Object[rowNo][2];
		int dim = 0;

		for(int iRow=0;iRow<rowNo;iRow++) {
			dataArray[dim][0] = iRow+1;
			dataArray[dim][1] = dataSet.get(iRow);
			dim++;
		}
		return dataArray;
	}



	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	public void launchApp() {
		driver.get(TestConfig.getProperty("appBaseURL"));
	}
	
	@AfterClass
	public void cleanUp() {
		if(driver!=null) {
			driver.quit();
		}
	}
	

}
