package webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class search {
	WebDriver driver;
	By app = By.xpath("//a[contains(text(),'View All Apps and Tools')]"); 
	By search =By.xpath("/html[1]/body[1]/div[1]/app-root[1]/main[1]/div[1]/unily-spa[1]/dynamic-content-viewer[1]/section[1]/upgrade-component-wrapper[1]/div[1]/div[1]/div[1]/div[1]/generic-search[1]/div[1]/div[1]/div[1]/div[1]/generic-search-refiners[1]/div[1]/input[1]") ;
	By btn = By.xpath("/html[1]/body[1]/div[1]/app-root[1]/main[1]/div[1]/unily-spa[1]/dynamic-content-viewer[1]/section[1]/upgrade-component-wrapper[1]/div[1]/div[1]/div[1]/div[1]/generic-search[1]/div[1]/div[1]/div[1]/div[1]/generic-search-refiners[1]/div[1]/span[1]/button[1]");
	
	//Constructor to initialize object
		public search(WebDriver driver) {
			this.driver = driver;
		}
		public void Setapp() {
			driver.findElement(app).click();
		}
		public void SetSearch(String a) {
			driver.findElement(search).sendKeys(a);
		}
		public void Setbutton() {
			driver.findElement(btn).click();
		}
		
		
}

