package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		    String baseURL = "https://admin-dev-beta.lifepod.com/";			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\maharjans\\workspace\\Seleniumtutorial\\libs\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.get(baseURL);
			//login to dev-beta portal
			driver.findElement(By.name("username")).sendKeys("millie+caregiver@lifepod.com");
			driver.findElement(By.name("password")).sendKeys("xyz");
			Thread.sleep(2000);
			
			
			//select the appropriate senior account from the left nav panel
			driver.findElement(By.className("btn-primary")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("nav-item-special")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("switch-caregivee")).click();
			Thread.sleep(2000);
			
			//Click on Routines then Add Routines
			driver.findElement(By.linkText("Routines")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.className("d-sm-inline-block")).click();
			Thread.sleep(2000);
			
			//Morning check-in drop-down menu for SMS alerts
			driver.findElement(By.linkText("Morning Check-In")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//input[@value = 'Morning Check-In']")).sendKeys(" sample");
			Thread.sleep(1500);
			//Select Weekly option for repeating of the routine
			driver.findElement(By.xpath(".//*[@class = 'fa fa-calendar clickable font-2xl mt-1 mx-2']")).click();
			Thread.sleep(2000);
			//Choose the date of routine setup which will determine the day for weekly repetition
			driver.findElement(By.xpath(".//td[contains(text(), '22')]")).click();
			Thread.sleep(2000);
			
			/*
			//Play all the replies on the browser for the Morning Check-in
			driver.findElement(By.xpath(".//div[@class = 'col-sm-8']/div[1]/div/div[2]/i")).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(".//div[@class = 'col-sm-8']/div[2]/div/div[2]/i")).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(".//div[@class = 'col-sm-8']/div[3]/div/div[2]/i")).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(".//div[@class = 'col-sm-8']/div[4]/div/div[2]/i")).click();
			Thread.sleep(8000);
			*/
			
			//Checking Alert me via text when Negative response is made
			
			driver.findElement(By.xpath(".//span[@class = 'sms-alert-when']/select")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath(".//select[@name = 'alertSmsType']/option[3]")).click();
			Thread.sleep(2000);

			//Save the routine
			driver.findElement(By.className("btn-save-and-close")).click();
			Thread.sleep(2000);
			
	//Going to the date the routine was setup for		
	driver.findElement(By.className("routine-list-date")).click();
	Thread.sleep(800);
	
	driver.findElement(By.xpath(".//td[@data-date = '1545436800000']")).click();
	Thread.sleep(1000);
	
	//Expanding the Morning Check-In sample routine
	driver.findElement(By.xpath(".//*[contains(text(), 'Morning Check-In sample')]")).click();
	Thread.sleep(5000);
	
	//Play on Lifepod now 
	driver.findElement(By.xpath(".//div[@data-target = '#summary-1774']/div[4]/div/a[2]/span")).click();
	Thread.sleep(15000);
	
	//Edit the title of the routine
	driver.findElement(By.xpath(".//div[@data-target = '#summary-1774']/div[4]/div/a[1]/span")).click();
	driver.findElement(By.xpath(".//input[@value = 'Morning Check-In sample']")).sendKeys(" edit");
	driver.findElement(By.className("btn-save-and-close")).click();

	//Play the routine on Lifepod again
	driver.findElement(By.xpath(".//div[@data-target = '#summary-1774']/div[4]/div/a[2]/span")).click();
	Thread.sleep(15000);
	
	//Duplicate the routine
	driver.findElement(By.xpath(".//div[@data-target = '#summary-1774']/div[4]/div/a[3]/span")).click();
	driver.findElement(By.xpath(".//input[@value = 'Morning Check-In sample']")).sendKeys(" 2");
	driver.findElement(By.className("btn-save-and-close")).click();
	Thread.sleep(1000);

	//Play the duplicate routine
	driver.findElement(By.xpath(".//div[@data-target = '#summary-1775']/div[4]/div/a[2]/span")).click();
	Thread.sleep(15000);
	
	//Delete the duplicate routine
	driver.findElement(By.xpath(".//div[@data-target = '#summary-1775']/div[4]/div/a[4]/span")).click();
	Thread.sleep(1000);
	//Click Yes for answer to question
	driver.findElement(By.className("btn btn-primary btn-yes")).click();
	Thread.sleep(500);
	
	
	//CAREGIVER profile editing
	driver.findElement(By.className("d-md-down-none")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("My Profile")).click();
	Thread.sleep(500);
	//Enter email that is not in the system
	driver.findElement(By.xpath(".//input[@name = 'email']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("sneha@gmail.com");
	driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
	//Enter non-email
	driver.findElement(By.xpath(".//input[@name = 'email']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("sneha@gmail");
	driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
	//Enter valid email that is in the system
	driver.findElement(By.xpath(".//input[@name = 'email']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("sneha@lifepod.com");
	driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
	 
	
	//Change password for caregiver
	driver.findElement(By.className("change-password")).click();
	driver.findElement(By.xpath(".//input[@name = 'currentPassword']")).sendKeys("myAlpha2!");
	driver.findElement(By.xpath(".//input[@name= 'newPassword']")).sendKeys("myAlpha3!");
	driver.findElement(By.xpath(".//input[@name = 'newPasswordConfirm']")).sendKeys("myAlpha3!");
	driver.findElement(By.className("btn-save-and-close")).click();
	Thread.sleep(2000);

	//Logout and login with the new password
	driver.findElement(By.className("d-md-down-none")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Logout")).click();
	//login to dev-beta portal using new password
	driver.findElement(By.name("username")).sendKeys("jackie+caregiver-alpha2@lifepod.com");
	driver.findElement(By.name("password")).sendKeys("myAlpha3!");
	Thread.sleep(2000);
	
	//More changes to the caregiver profile
	driver.findElement(By.className("d-md-down-none")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("My Profile")).click();
	Thread.sleep(500);
	//Change the display name
	driver.findElement(By.xpath(".//input[@name = 'goesBy']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'goesBy']")).sendKeys("Froot-loops");
	driver.findElement(By.xpath(".//input[@name = 'firstName']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'firstName']")).sendKeys("Mamma");
	driver.findElement(By.xpath(".//input[@name = 'lastName']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'lastName']")).sendKeys("Mia");
	Thread.sleep(1000);
	
	//Check or uncheck the "This phone can receive texts checkbox
	driver.findElement(By.className("custom-control-label")).click();
	Thread.sleep(500);
	driver.findElement(By.className("input-phone")).clear();
	Thread.sleep(500);
	driver.findElement(By.className("input-phone")).sendKeys("9990003547");
	
	//Select the caregiver's birth-date
	driver.findElement(By.className("routine-list-date")).click();
	driver.findElement(By.xpath(".//td[@data-date = '1529884800000']")).click(); //can do further tests by trying to choose a later date
	Thread.sleep(500);
	
	//Select the caregiver's timezone
	driver.findElement(By.xpath(".//select[@name = 'timezone']")).click();
	driver.findElement(By.xpath(".//option[@value = 'America/New_York']")).click(); //selected Eastern time for now can choose any time-zone and should not affect the senior's routine timetable
	Thread.sleep(800);
	
	//Update the caregiver profile
	driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
	Thread.sleep(800);
	
	
	//Senior's settings page
	//Change the display name, first name and last name
	driver.findElement(By.xpath(".//input[@name = 'goesBy']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'goesBy']")).sendKeys("Shimmi-kimmi");
	driver.findElement(By.xpath(".//input[@name = 'firstName']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'firstName']")).sendKeys("Ariana");
	driver.findElement(By.xpath(".//input[@name = 'lastName']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'lastName']")).sendKeys("Grande");
	Thread.sleep(1000);
	//Change the zip code
	driver.findElement(By.xpath(".//input[@name = 'zip']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'zip']")).sendKeys("02115");
	//Select a DOB
	driver.findElement(By.xpath(".//input[@name = 'dob']")).click();
	driver.findElement(By.xpath(".//td[@data-date = '1535673600000']")).click();
	//try selecting a date after the current date to see if bug exists
	driver.findElement(By.xpath(".//td[@data-date = '1547856000000']")).click();
	//Select senior's timezone
	driver.findElement(By.xpath(".//select[@name = 'timezone']")).click();
	driver.findElement(By.xpath(".//option[@value = 'America/Chicago']")).click(); //Central timezone
	driver.findElement(By.xpath(".//button[@title = 'Update']")).click();
	Thread.sleep(1000);
	
	//ADD a new care team member
	driver.findElement(By.linkText(" Care Team")).click(); //link text format is different so may not work
	driver.findElement(By.className("add-contact")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(".//input[@name = 'firstName']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'firstName']")).sendKeys("Madam");
	driver.findElement(By.xpath(".//input[@name = 'lastName']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'lastName']")).sendKeys("Curie");
	driver.findElement(By.xpath(".//input[@name = 'goesBy']")).clear();
	driver.findElement(By.xpath(".//input[@name = 'goesBy']")).sendKeys("Marie");
	
	//choosing the relationship
	driver.findElement(By.xpath(".//select[@name = 'appUserCaregiver.relationshipType']")).click();
	driver.findElement(By.xpath(".//option[@value = '1']")).click(); //family
	
	//Choosing user's role
	driver.findElement(By.xpath(".//select[@name = 'appUserCaregiver.userRoles']")).click();
	driver.findElement(By.xpath(".//option[vaule = '1']")).click();	//primary caregiver
	
	//Entering a phone number for the caregiver
	driver.findElement(By.className("input-phone")).clear();
	driver.findElement(By.className("input-phone")).sendKeys("987654321");
	//Enable SMS alerts
	driver.findElement(By.xpath(".//input[@name = 'isPhoneSmsEnabled']")).click();
	//enter an email address
	
		//Enter email that is not in the system
		driver.findElement(By.xpath(".//input[@name = 'email']")).clear();
		driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("sneha@gmail.com");
		driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
		//Enter non-email
		driver.findElement(By.xpath(".//input[@name = 'email']")).clear();
		driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("sneha@gmail");
		driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
		//Enter valid email that is in the system
		driver.findElement(By.xpath(".//input[@name = 'email']")).clear();
		driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("sneha@lifepod.com");
		driver.findElement(By.xpath(".//button[@id = 'save-profile']")).click();
		
		//Select a DOB
		driver.findElement(By.xpath(".//input[@name = 'dob']")).click();
		driver.findElement(By.xpath(".//td[@data-date = '1535673600000']")).click();
	
		//select the timezone
		driver.findElement(By.xpath(".//select[@name = 'timezone']")).click();
		driver.findElement(By.xpath(".//option[@value = 'America/New_York']")).click(); 
		
		driver.findElement(By.className("btn-save-and-close")).click();

	//Test to see if Back arrow on any Reports page redirects to correct previous page
		driver.findElement(By.linkText(" Reports")).click();
		Thread.sleep(1000);
		//Server Application Log
		driver.findElement(By.xpath(".//tr[@onclick = 'amplify.publish(AppEvents.REPORT.SHOW_APP_LOG);']")).click();
		driver.navigate().back();// going back to the previous webpage
		Thread.sleep(2000);
		
		//if it returns to another webpage, preferably the one which you were on before the Reports page
		//then we have to click on the main reports option on the left handside menu
		driver.findElement(By.linkText(" Reports")).click();
		Thread.sleep(1000);
		//Current Device Status
		driver.findElement(By.xpath(".//tr[@onclick = 'amplify.publish(AppEvents.REPORT.NOC_REPORT);']")).click();
		driver.navigate().back();// going back to the previous webpage
		Thread.sleep(2000);
		
		driver.findElement(By.linkText(" Reports")).click();
		Thread.sleep(1000);
		//Account Link Status
		driver.findElement(By.xpath(".//tr[@onclick = 'amplify.publish(AppEvents.REPORT.AMAZON_LINKING_BY_EMAIL);']")).click();
		driver.navigate().back();// going back to the previous webpage
		Thread.sleep(2000);
		
		driver.findElement(By.linkText(" Reports")).click();
		Thread.sleep(1000);
		//Senior Device Activity Report
		driver.findElement(By.xpath(".//tr[@onclick = 'amplify.publish(AppEvents.REPORT.SENIOR_DEVICE_ACTIVITY_REPORT);']")).click();
		driver.navigate().back();// going back to the previous webpage
		Thread.sleep(2000);
		
		driver.findElement(By.linkText(" Reports")).click();
		Thread.sleep(1000);
		//SMS Messages Sent by Email
		driver.findElement(By.xpath(".//tr[@onclick = 'amplify.publish(AppEvents.REPORT.SMS_MESSAGES_SENT);']")).click();
		driver.navigate().back();// going back to the previous webpage
		Thread.sleep(2000);
		
		driver.findElement(By.linkText(" Reports")).click();
		Thread.sleep(1000);
		//Device Log
		driver.findElement(By.xpath(".//tr[@onclick = 'amplify.publish(AppEvents.REPORT.SOCKET_STATISTICS);']")).click();
		driver.navigate().back();// going back to the previous webpage
		Thread.sleep(2000);
		
		

			/*
			driver.findElement(By.className("d-sm-inline-block")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Medication")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("close")).click();
			Thread.sleep(2000);
			
			
			driver.findElement(By.className("d-sm-inline-block")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Daily Exercise")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("close")).click();
			Thread.sleep(2000);
			
			
			driver.findElement(By.className("d-sm-inline-block")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Hydration")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("close")).click();
			Thread.sleep(2000);
			
			
			driver.findElement(By.className("d-md-down-none")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();
			
*/
	
	}

}
