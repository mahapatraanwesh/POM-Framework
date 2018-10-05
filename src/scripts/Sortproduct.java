package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import generics.Auto_constant;
import generics.Excel;
import pom.Loginpage;
import pom.Welcomepage;

public class Sortproduct implements Auto_constant {
	static
	{
		System.setProperty("webdriver.chrome.driver","./Software/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://kraftly.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
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
		wp.searchtb(Excel.abc(excelPath, "Sheet1", 5, 0));
		wp.searchiconbtn();
		
}
}
