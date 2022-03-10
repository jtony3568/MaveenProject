package org.fbpom;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFb extends BaseClass {

	public LoginFb() {
	
			PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	private WebElement txtUserName;
	
	@FindBy(id="pass")
	private WebElement txtPass;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	
	

	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPass() {
		return txtPass;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}

	
}