package webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {

WebDriver driver;

By email = By.xpath("//input[@id='i0116']");
By next = By.xpath("//input[@id='idSIButton9']");
By pwd = By.xpath("//input[@id='i0118']");
By signin = By.xpath("/html/body/div/form[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/div/div/div/div/input");
By way = By.xpath("//a[@id='signInAnotherWay']");
By call = By.xpath("//div[contains(text(),'Call +XX XXXXXXXX94‎')]");
By stay = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/input[1]");//Constructor to initialize object

public login(WebDriver driver)
{
	this.driver=driver;
}
public void enteremail(String e)
{	
	driver.findElement(email).sendKeys(e);
}
public void setNext()
{	
	driver.findElement(next).click();
}
public void enterpwd(String p)
{
	driver.findElement(pwd).sendKeys(p);
}
public void setsing()
{	
	driver.findElement(signin).click();
}
public void setWay()
{
	driver.findElement(way).click();
}
public void setCall()
{
	driver.findElement(call).click();
}
public void setyes()
{
	driver.findElement(stay).click();
}


}
