package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DetailsPage {

	private WebDriver driver;
	private final String url = "https://hoteltonight.com/san-diego/details-0";

    public DetailsPage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
    }

    /**
     * @doc Methods
     * @name getTitle
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, and Get Page Title 
     *
     */
    public String getTitle() {
        return driver.getTitle();
    }
    /**
     * @doc Methods
     * @name getContent
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, and Get Page Source  
     *
     */
    public String getContent() {
        return driver.getPageSource();
    }
    /**
     * @doc Methods
     * @name hotelTitle
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Element Hotel Name 
     *
     */
    private WebElement hotelName(){
		return driver.findElement(By.xpath("//div[@class='details-header cf']/span[@class='name']"));
	}
    /**
     * @doc Methods
     * @name getHotelTitle
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get Hotel Name Text 
     *
     */
	public String getHotelName(){
		return hotelName().getText();
	}
	
	 /**
     * @doc Methods
     * @name hotelPrice
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Hotel Price Element 
     *
     */
	private WebElement hotelPrice(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[1]/span[2]/span[2]"));
	}

	/**
     * @doc Methods
     * @name getHotelPrice
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get  Hotel Price Text
     *
     */
	public String getHotelPrice(){
		return hotelPrice().getText();
	}
	/**
     * @doc Methods
     * @name hotelCategory
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find hotel Category Element  
     *
     */
	private WebElement hotelCategory(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[1]/img"));
	}
	/**
     * @doc Methods
     * @name getHotelCategory
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will  get  Category   Text
     *
     */
	public String getHotelCategory(){
		String category = hotelCategory().getAttribute("alt").substring(9);
		return category ;
	}
	/**
     * @doc Methods
     * @name likeIT
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Why We Like It Element  
     *
     */
	private WebElement likeIT(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[4]/h3"));
	}
	/**
     * @doc Methods
     * @name getlikeIT
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get Why We Like It Text 
     *
     */
	public String getlikeIT(){
		return likeIT().getText();
	}
	/**
     * @doc Methods
     * @name amenities
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Hotel Amenities Element  
     *
     */
	private WebElement amenities(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[5]/h3"));
	}
	/**
     * @doc Methods
     * @name getAmenities
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get Hotel Amenities Text  
     *
     */
	public String getAmenities(){
		return amenities().getText();
	}
	/**
     * @doc Methods
     * @name roomDetails
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Room Details Element  
     *
     */
	private WebElement roomDetails(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[6]/h3"));
	}
	/**
     * @doc Methods
     * @name roomDetails
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get Room Details Text   
     *
     */
	public String getRoomDetails(){
		return roomDetails().getText();
	}
	/**
     * @doc Methods
     * @name foodOptions
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Food Options Element  
     *
     */
	private WebElement foodOptions(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[7]/h3"));
	}
	/**
     * @doc Methods
     * @name foodOptions
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get Food Options text  
     *
     */
	public String getfoodOptions(){
		return foodOptions().getText();
	}
	/**
     * @doc Methods
     * @name needToKnow
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will find Need to Know Element  
     *
     */
	private WebElement needToKnow(){
		return driver.findElement(By.xpath("//*[@id='viewport']/div[1]/div/div[2]/div[8]/h3"));
	}
	/**
     * @doc Methods
     * @name getNeedToKnow
     * @methodOf DetailsPage
     * @description  Open up Details page, will wait for  page to load, will get Need to Know Text
     *
     */
	public String getNeedToKnow(){
		return needToKnow().getText();
	}
	/**
	   * @doc Methods
	   * @name navigation
	   * @methodOf DetailsPage
	   * @description Click on Book now and Navigate  to Registration Page
	   */
	public RegistrationPage navigation() {
		
		try{
			WebElement element = driver.findElement(By.xpath("//div[@class='book-now-button details-button-top']"));
			element.click();
		}catch (Exception e){
			
		}
		
		return new RegistrationPage(driver);
	}
}
