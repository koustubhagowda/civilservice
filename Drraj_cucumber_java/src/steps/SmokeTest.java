package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest
{
	WebDriver driver;
	@Given("^Open chrome and start application$")
	public void Open_chrome_and_start_application() throws Throwable
	{
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    driver.get("http://drrajkumaracademy.com/");
	}
	@When("^I enter valid credentials$")
	public void I_enter_valid_credentials() throws Throwable
	{
		driver.findElement(By.xpath("//div[@class='modal-header']/button")).click();
				
//		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/ul/li[5]/a")).click();

//		WebElement element = driver.findElement(By.xpath("//i[@class='fa fa-instagram']"));
//		Actions action = new Actions(driver);
//		action.moveToElement(element).click().perform();
		
		WebElement select = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/ul/li[5]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", select);
		driver.findElement(By.id("full_name")).sendKeys("koustubha k");
		driver.findElement(By.id("parents")).sendKeys("keshavaswamy k y");
		driver.findElement(By.id("address")).sendKeys("D/O keshavaswamy k y\nkyathanahalli\npandavapura taluk\nmandya district");
		driver.findElement(By.id("city")).sendKeys("mandya");
		driver.findElement(By.id("pincode")).sendKeys("571427");
		driver.findElement(By.id("education")).sendKeys("BE");
		driver.findElement(By.id("email")).sendKeys("koust@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("7685940303");
		driver.findElement(By.xpath("//*[@value='KAS']")).click();
		driver.findElement(By.xpath("//*[@value='General Studies(Prelims)']")).click();
		driver.findElement(By.xpath("//*[@value='Any Other']")).click();
		driver.findElement(By.id("kas_other_option")).sendKeys("Hostory");
		driver.findElement(By.xpath("//*[@value='W']")).click();
		driver.findElement(By.id("registerBtn")).click();
	}

	@Then("^User should be able to see register successfully$")
	public void User_should_be_able_see_register_successfully() throws Throwable
	{
		String web = driver.findElement(By.xpath("//strong[contains(text(),'Mail sent for Verification..')]")).getText();
		System.out.println(web);
		driver.quit();
	}

}
