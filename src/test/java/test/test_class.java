package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import setup.driver_setup;
import setup.screenshot;
import webpage.login;
import webpage.resource;
import webpage.search;



public class test_class {

	WebDriver driver;
	login l;
	search s;
	resource r;
	int i = 0;
	
	// Launch of the given browser.
    @BeforeTest
	public void browserlaunch() throws NullPointerException
	{
		driver = driver_setup.StartBrowser("Chrome", "https://login.microsoftonline.com/de08c407-19b9-427d-9fe8-edf254300ca7/oauth2/authorize?client_id=d51c9caa-a78c-42d5-ba89-ffa9a2225c33&redirect_uri=https%3A%2F%2Fbe.cognizant.com%2F&response_type=code%20id_token&scope=openid%20profile%20email&state=OpenIdConnect.AuthenticationProperties%3DN5OzFt_7-ePkaeSOm-j0-MbWA-4zaeKjTrWxynD6eVpiJ-l-lLnhGo130856aSpDwH_7E53NuabOhzQrCICmNdK4IFXESTDym3fDB8XD5pyxieapaDsbkWkSsOyk-96JjzhR6dkM2cedqn-5wpvRH3WzXeukpZcIWfP0VYcxlOJZ5noTnPGe_NWMMw3QAR6_HCiL-MwFvo0pBBQOqXpVMkGkhw37ZwW5BvmfrL-MfFAQAEa1a_lbbs-08xKLBN4zUBbR6cBzEDyvAKXx6tRBTqrREeyQoS38zz7YgIPrmVUEb1aryQdhPsQfQ6bEpZ-AD8CzsMyzbM_TNXB9j0hWLHSLnMFz2NQQnxcCmLsJnUo&response_mode=form_post&nonce=637433806492754370.OTM3MDRhOGMtYTUyMi00MjI4LWEwM2QtZjg4NjViNTM0ZjlhNGYwMzNkMjAtMDA0OC00YzYyLWIzYjgtNTMwNTlhZTZkM2E0&x-client-SKU=ID_NET461&x-client-ver=5.6.0.0&sso_reload=true");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		l = new login(driver);
		s = new search(driver);
		r = new resource(driver);		
	}
        
    @SuppressWarnings("resource")
	@Test(priority = 1) // login page
    public void homeSearch() throws InterruptedException, IOException {
    	String username = null;
    	String password = null;
    	//taking login data from input.xlxs file
       	File file = new File("C:\\Users\\PRIYA BIR\\eclipse-workspace\\Assignment\\input.xlsx"); 
    	FileInputStream iFile = new FileInputStream(file);
    	XSSFWorkbook wb = new XSSFWorkbook(iFile);      
    	XSSFSheet sheet = wb.getSheetAt(0); 
    	XSSFRow row = sheet.getRow(0);
        XSSFCell cell1 = row.getCell(0);
        XSSFCell cell2 = row.getCell(1);
        username = cell1.toString();
    	password = cell2.toString();
    	iFile.close();
    	l.enteremail(username);
    	l.setNext();
    	l.enterpwd(password);
    	l.setsing();
    	l.setWay();
    	Thread.sleep(1000);
    	l.setCall();
    	l.setyes();	
     }
    
    @Test(priority = 2) //search page
    public void afterSearch() throws InterruptedException {
    	s.Setapp();
    	s.SetSearch("MyAssignments");
    	s.Setbutton();   	
    }
   
    @Test(priority = 3) //resource current page
    public void getCurrent() throws InterruptedException {
    	r.navigate();
    	Thread.sleep(1000);
        r.getCurrent();
    	r.printCurrent();
    }
        
    @Test(priority = 4) //resource history page
    public void getHistory() throws InterruptedException {
       r.Sethistory();
       Thread.sleep(1000);
       r.getHistory();;
       r.printHistory(); 
    }
  
    @Test(priority = 5) // store data in excel file
    public void setexcel() throws IOException{
    	r.writeExcelData();
    }
    
    @AfterMethod
    //get screenshot
    public void screenshot(ITestResult result){
      i = i+1;
      String name = "ScreenShot";
      String x = name + String.valueOf(i);
          if(ITestResult.SUCCESS == result.getStatus())
             {
        	  screenshot.captureScreenShot(driver, x);// Taking Screen shot on test 
              }
   }
    @AfterTest
    //close the browser
    public void closeBrowser(){
       driver.quit();
    }
}