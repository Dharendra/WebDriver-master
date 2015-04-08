package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegistrationPage {

    private WebDriver driver;
    

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @doc Methods
     * @name getTitle
     * @methodOf RegistrationPage
     * @description  Open up RegistrationPage page, will wait for  page to load, and Get Page Title 
     *
     */
    public String getTitle() {
        return driver.getTitle();
    }
    /**
     * @doc Methods
     * @name getTitle
     * @methodOf RegistrationPage
     * @description  Open up RegistrationPage page, will wait for  page to load, and Get Page Source  
     *
     */
    public String getContent() {
        return driver.getPageSource();
    }
    /**
     * @doc Methods
     * @name enterEmail
     * @methodOf RegistrationPage
     * @exception Catches Exception if element not found
     * @description  Open up RegistrationPage page, will wait for  page to load, and Enter a new Email Address Every time
     *
     */
    public void enterEmail(){
		try{
			WebElement element = driver.findElement(By.id("email-address"));
			String s = String.valueOf(System.currentTimeMillis());
			String data = "htbook" +s+ "@gmail.com";
			element.clear();
			element.sendKeys(data);
			System.out.println(data);
	}catch (Exception e){
			
		}
	}
    /**
     * @doc Methods
     * @name firstName
     * @methodOf RegistrationPage
     * @exception Catches Exception if element not found
     * @description  Open up RegistrationPage page, will wait for  page to load, and Enter a new First Name Every time
     *
     */
    public void firstName(){
		try{
			WebElement element = driver.findElement(By.id("first-name"));
			String s = String.valueOf(System.currentTimeMillis());
			String data = "Dhar" + s;
			element.sendKeys(data);
			System.out.println(data);
	}catch (Exception e){
			
		}
	}
    /**
     * @doc Methods
     * @name lastName
     * @methodOf RegistrationPage
     * @exception Catches Exception if element not found
     * @description  Open up RegistrationPage page, will wait for  page to load, and Enter a new Last Name Every time
     *
     */
    public void lastName(){
		try{
			WebElement element = driver.findElement(By.id("last-name"));
			String s = String.valueOf(System.currentTimeMillis());
			String data = "Mann" + s;
			element.sendKeys(data);
			System.out.println(data);
	}catch (Exception e){
			
		}
	}
    /**
     * @doc Methods
     * @name book
     * @methodOf RegistrationPage
     * @exception Catches Exception if element not found
     * @description  Open up RegistrationPage page, will wait for  page to load, after First name ,Last name and Email address are entered, Click book Button
     *
     */
    public void book(){
    	try{
			WebElement element = driver.findElement(By.xpath("//div[@class='purchase-button']"));
			element.click();
	}catch (Exception e){
			
		}
	}
    

}
