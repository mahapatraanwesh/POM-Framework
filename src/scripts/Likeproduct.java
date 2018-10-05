package scripts;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import generics.Auto_constant;
import generics.Excel;
import pom.Likepage;
import pom.Loginpage;
import pom.Productpage;
import pom.Welcomepage;
import pom.Mensection;
public class Likeproduct implements Auto_constant
{
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
		lp.emailtb(Excel.abc(excelPath, "Sheet1", 0, 1));
		lp.passwordtb(Excel.abc(excelPath, "Sheet1", 1, 1));
		lp.signinenter();
		Thread.sleep(3000);
		Mensection ws=new Mensection(driver);
		Thread.sleep(3000);
		ws.womensection(driver);
		ws.ethnicwear(driver);
		ws.lehengaslink();
		ws.product1();
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(a.get(1));
		Productpage pp = new Productpage(driver);
		pp.like();
		wp.likedsection();
		Likepage likp = new Likepage(driver);
		String s = likp.prodCheck();
		
		if(s == "Yellow Partywear Gown") {
			System.out.println("pass");
		}
		else System.out.println("fail");

		Thread.sleep(3000);
		wp.accountbutton();
		wp.logoutbtn();		
	}
}
