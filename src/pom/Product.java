package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Product
{
	    @FindBy(xpath="//div[@class='addtoCart']")
	    private WebElement addtocartbtn;
	    @FindBy(name="pincheck")
	    private WebElement pintb;
	    @FindBy(xpath="//input[@class='pincode-verify']")
	    private WebElement checkbtn;
	    @FindBy(xpath="//a[@class='pd_allReview']")
	    private WebElement reviewbtn;
	    public Product(WebDriver driver)
	    
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    public void addtocart() {
	    	addtocartbtn.click();
	    }
	    public void enterpin(String a)
	    {
	    	pintb.sendKeys(a);
	    }
	    public void check() {
	    	checkbtn.click();
	    }
	    public void Review() {
	    	reviewbtn.click();
	    }
	}

