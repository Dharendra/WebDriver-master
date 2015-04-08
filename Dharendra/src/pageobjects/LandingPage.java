package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private WebDriver driver;
    private final String url = "https://hoteltonight.com/san-diego";
   

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
    }
    /**
     * @doc Methods
     * @name getTitle
     * @methodOf LandingPage
     * @description  Open up LandingPage page, will wait for  page to load, and Get Page Title 
     *
     */
    public String getTitle() {
        return driver.getTitle();
    }
    /**
     * @doc Methods
     * @name hotelsArePresent
     * @methodOf LandingPage
     * @description  Open up LandingPage page, will wait for  page to load, 
     *               and Verify : Hotels Name are not null.  Since the Content Displayed on the Landing page is Dynamic. 
     *               Not Null Verification will at least help to verify some text value is Displayed.
     *               Also Verify the presence of Element containing Price and Location
     *  
     *
     */
    public void hotelsArePresent (){
    	for(int i=1; i<=15; i++) {
    		WebElement list = driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]" + "/div["+i+"]/div[2]/span[1] "));
    		assertNotNull(list.getText());
    		System.out.println(list.getText());
    		WebElement info = driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]" + "/div["+i+"]/div[2]"));
    		assertTrue(info.isDisplayed());	
    	} 	
    }
    
    /**
	   * @doc Methods
	   * @name navigation
	   * @methodOf LandingPage
	   * @description Click on any hotel and Navigate to  hotels details page
	   */
	public DetailsPage navigation(int i) {
		
		try{
			WebElement element = driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]"+ "/div["+i+"]/div[2]/span[2]"));
			element.click();
		}catch (Exception e){
			
		}
		
		return new DetailsPage(driver);
	}
	/**
     * @doc Methods
     * @name hotelTitle
     * @methodOf LandingPage
     * @description  Open up Landing  Page, will wait for  page to load, will find Element Hotel Name 
     *
     */
	private WebElement hotelName(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[1]/div[2]/span[1]"));
	}
	/**
     * @doc Methods
     * @name getHotelTitle
     * @methodOf LandingPage
     * @description  Open up Landing  Page, will wait for  page to load, will get Element Hotel Name Text
     *
     */
	public String getHotelName(){
		return hotelName().getText();
	}
	/**
     * @doc Methods
     * @name hotelPrice
     * @methodOf LandingPage
     * @description  Open up Landing  Page,  will wait for  page to load, will find Hotel Price Element 
     *
     */
	private WebElement hotelPrice(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[1]/div[2]/span[4]/span[2]"));
	}
	/**
     * @doc Methods
     * @name getHotelPrice
     * @methodOf LandingPage
     * @description  Open up Landing  Page,  ill wait for  page to load, will find Hotel Price Text 
     *
     */
	public String getHotelPrice(){
		return hotelPrice().getText();
	}
	/**
     * @doc Methods
     * @name hotelPrice
     * @methodOf LandingPage
     * @description  Open up Landing  Page,  will wait for  page to load, find hotel Category Element  
     *
     */
	private WebElement hotelCategory(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[1]/div[2]/span[2]/img"));
	}
	/**
     * @doc Methods
     * @name getHotelCategory
     * @methodOf LandingPage
     * @description  Open up Landing  Page,  will wait for  page to load, will  get  Category   Text
     *
     */
	public String getHotelCategory(){
		String category = hotelCategory().getAttribute("alt").substring(9);
		return category ;
	}
}
