package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import POM.users;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Users 
{
	WebDriver driver;
	private login lp;
	private users us;


	@Given("I am on the Add User page")
	public void i_am_on_the_add_user_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();

		//user click users link and click All users link
		us=new users(driver);
		us.clickUsers();
		WebElement clickAllUsers = driver.findElement(By.xpath("//span[normalize-space()='All Users']"));
		clickAllUsers.click();
		
//		//user click + icon
		driver.findElement(By.xpath("//mat-icon[normalize-space()='person_add']")).click();
//		
//		//verify page tittle
		String expectedtittle = "Add Users";
		String actualtittle= driver.findElement(By.xpath("//h1[normalize-space()='Add User']")).getText();
//		
//		//to print page tittle
		System.out.println("actual page tittle : "+actualtittle);
		
		if(actualtittle.equals(actualtittle))
		{
			System.out.println("Page tittle matches the expected tittle");
		}else 
		{
			System.out.println("Page tittle does not match the expected tittle");
		}


		
	}
	@When("I enter {string} in the Name field")
	public void i_enter_in_the_name_field(String Name) 
	{
	   driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Name);
	}
	@When("I enter {string} in the Email field")
	public void i_enter_in_the_email_field(String Email) 
	{
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
	}
	@When("I enter {string} in the Mobile No. field")
	public void i_enter_in_the_mobile_no_field(String mobileNo) 
	{
		  driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys(mobileNo);

	}
	@When("I enter {string} in the City field")
	public void i_enter_in_the_city_field(String mobileNo) 
	{
		  driver.findElement(By.xpath("//input[@name='city']")).sendKeys(mobileNo);

	}
	@When("I enter {string} in the About user field")
	public void i_enter_in_the_about_user_field(String description) 
	{
		  driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
	}
	@When("I select {string} from the User Role dropdown")
	public void i_select_from_the_user_role_dropdown(String role) 
	{
	    WebElement element = driver.findElement(By.xpath("//input[@role='combobox']"));
	    element.sendKeys(role);
	    element.sendKeys(Keys.ENTER);

	}

	@When("I enter {string} in  Password field and enter {string} in the Password \\(Confirm) field")
	public void i_enter_in_password_field_and_enter_in_the_password_confirm_field(String pwd, String confirmpwd) 
	{
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
	   driver.findElement(By.xpath("//input[@name='passwordConfirm']")).sendKeys(confirmpwd);

	}



	@When("I check the Visibility features toggle")
	public void i_check_the_visibility_features_toggle() 
	{
	  driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb'])[1]")).click();

	}

	@When("I assign course says {string}")
	public void i_assign_course_says(String course) throws Throwable 
	{
		  WebElement element=driver.findElement(By.xpath("//input[@placeholder='Enter Course']"));
		  element.sendKeys(course);
		  Thread.sleep(1000);
		  element.sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  element.sendKeys(Keys.ENTER);
	}



	@When("I attach {string} to the Upload Image field")
	public void i_attach_to_the_upload_image_field(String UploadImagePath) throws Throwable 
	{
	  WebElement element= driver.findElement(By.xpath("//em[@class='material-icons upload']"));
	  element.click();
	   Thread.sleep(2000);
	   // Switch to the popup window
       String mainWindowHandle = driver.getWindowHandle();
       Set<String> allWindowHandles = driver.getWindowHandles();
       for (String handle : allWindowHandles) 
       {
           if (!handle.equals(mainWindowHandle)) 
           {
               driver.switchTo().window(handle);
               break;
           }
       }

       WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
       String workingDir = System.getProperty("user.dir");
//       String filePath = workingDir + "\\images\\images.png";
       String filePath = workingDir + UploadImagePath;

       fileInput.sendKeys(filePath);
       
       //click crop button
//       driver.switchTo().window(mainWindowHandle);
       driver.findElement(By.xpath("(//*[normalize-space()='Crop and Continue'])[1]")).click();
       

	}
	

	@When("I click the create user button")
	public void i_click_the_create_user_button() throws Throwable 
	{
	  driver.findElement(By.xpath("//span[normalize-space()='Create User']")).click();
	  Thread.sleep(1000);

	}

	

	@Then("I should see validation message says {string}")
	public void i_should_see_validation_message_says(String ResultMessage)
	{
		 WebElement errorMessage = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
	        System.out.println("Error Message is : " + errorMessage.getText());

	        assertEquals(ResultMessage, errorMessage.getText());
	}



	
	
	
	@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String ConfirmationMessage) 
	{
		 // Validate confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='toast-title']"));
        assertEquals(ConfirmationMessage, confirmationMessage.getText());
	}
	
	@Then("the user {string} should be listed in the Users table")
	public void the_user_should_be_listed_in_the_users_table(String Name) 
	{
		// Validate the user is listed in the Users table
        WebElement usersTable = driver.findElement(By.xpath("(//td[starts-with(@class, 'ng-tns')])[1]"));
        System.out.println("created user is : " + usersTable.getText());
        assertTrue(usersTable.getText().contains(Name));
	}

//scenario -2 existing user error message verify
	

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String errorMsg) 
	{
		 WebElement errorMessage = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
	        System.out.println("Error Message is : " + errorMessage.getText());

	        assertEquals(errorMsg, errorMessage.getText());
	}
//-----------------------------------------------------------------------------------------------------------

//scenario - verify Password validation message

	@Then("I should see a password validation message {string}")
	public void i_should_see_a_password_validation_message(String pwdvalidationMsg) 
	{
		 WebElement errorMessage = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
	        System.out.println("password validation Message is : " + errorMessage.getText());

	        assertEquals(pwdvalidationMsg, errorMessage.getText());
	}




}
