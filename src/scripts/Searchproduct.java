package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

import generics.Auto_constant;
import generics.Excel;
import pom.Loginpage;
//import pom.Product;
import pom.Productpage;
import pom.Welcomepage;

public class Searchproduct implements Auto_constant
{
	static
	{
		System.setProperty("webdriver.gecko.driver","./Software/geckodriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://kraftly.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Welcomepage wp = new Welcomepage(driver);
		Thread.sleep(3000);
		wp.signupbtn();
		Thread.sleep(3000);
		wp.signinbtn();
		Loginpage lp = new Loginpage(driver);
		lp.emailtb(Excel.abc(excelPath, "Sheet1", 1, 0));
		lp.passwordtb(Excel.abc(excelPath, "Sheet1", 1, 1));
		lp.signinenter();
		Thread.sleep(3000);
		wp.searchtb(Excel.abc(excelPath, "Sheet1", 1, 2));
		wp.searchiconbtn();
		Thread.sleep(3000);
		Productpage pp=new Productpage(driver);
		pp.productclick();
		pp.prodclick();
		Thread.sleep(3000);
		wp.accountbutton();
		wp.logoutbtn();Thread.sleep(3000);
		}
}
