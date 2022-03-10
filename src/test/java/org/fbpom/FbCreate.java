package org.fbpom;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FbCreate extends BaseClass{
	
	public FbCreate() {
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup
	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement btnCreate;
	@FindBys({@FindBy(xpath="(//input[@type='text'])[2]"),@FindBy(name="firstname")})
	private WebElement txtFirst;
	@FindAll({@FindBy(xpath="(//input[@type='text'])[3]"),@FindBy(name="lastname")})
	private WebElement txtLast;
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement txtMob;
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement txtPass;
	@FindBy(name="birthday_age")
	private WebElement txtAge;
	@FindBy(xpath="(//input[@name='sex'])[2]")
	private WebElement radioSex;
	@FindBy(name="websubmit")
	private WebElement btnSignUp;
	
	public WebElement getBtnCreate() {
		return btnCreate;
	}
	public WebElement getTxtFirst() {
		return txtFirst;
	}
	public WebElement getTxtMob() {
		return txtMob;
	}
	public void setTxtMob(WebElement txtMob) {
		this.txtMob = txtMob;
	}
	public WebElement getTxtPass() {
		return txtPass;
	}
	public void setTxtPass(WebElement txtPass) {
		this.txtPass = txtPass;
	}
	public WebElement getTxtAge() {
		return txtAge;
	}
	public void setTxtAge(WebElement txtAge) {
		this.txtAge = txtAge;
	}
	public WebElement getRadioSex() {
		return radioSex;
	}
	public void setRadioSex(WebElement radioSex) {
		this.radioSex = radioSex;
	}
	public WebElement getTxtLast() {
		return txtLast;
	}
	public WebElement getBtnSignUp() {
		return btnSignUp;
	}

}
