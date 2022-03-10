package org.junitassert;

import java.util.Date;
import org.base.BaseClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fbpom.FbCreate;
import org.fbpom.LoginFb;

public class AssertA extends BaseClass {
	@BeforeClass
	public static void launch() throws ExceptionInInitializerError{
		try{
			browserLaunch("chrome");
		}
		catch(ExceptionInInitializerError e) {
			System.out.println("not passed");
		}
		maximise();
		implicitWait(20);
	}
	@Before
	public void dateTime() {
		System.out.println("start time"+new Date());
	}
	@Test
	public void fbLogin() throws InterruptedException {
		getUrl("https://www.facebook.com/");
		LoginFb  l= new LoginFb();
		Assert.assertTrue("varify url",getCurrentUrl().contains("facebook"));
		sendKeys(l.getTxtUserName(), "tony");
		Assert.assertEquals("vatrify user","tony", getAttribute(l.getTxtUserName()));
		sendKeys(l.getTxtPass(), "35426");
		Assert.assertEquals("varify pass","35426", getAttribute(l.getTxtPass()));
		click(l.getBtnLogin());
		Thread.sleep(5000);
		Assert.assertTrue(getCurrentUrl().contains("privacy_mutation_tocken"));
	}
	@Test
	public void fbCreate() throws InterruptedException {
		getUrl("https://www.facebook.com/");
		Assert.assertTrue("varify url",getCurrentUrl().contains("facebook"));
		FbCreate f = new FbCreate();
		click(f.getBtnCreate());
		Assert.assertEquals("varify 2nd url","https://www.facebook.com/", getCurrentUrl());
		sendKeys(f.getTxtFirst(), "tony");
		Assert.assertEquals("varify first name","tony", getAttribute(f.getTxtFirst()));
		sendKeys(f.getTxtLast(), "35677");
		Assert.assertEquals("varify last name","35677", getAttribute(f.getTxtLast()));
		sendKeys(f.getTxtMob(), "33687299");
		Assert.assertEquals("33687299", getAttribute(f.getTxtMob()));
		sendKeys(f.getTxtPass(), "324892013-");
		Assert.assertEquals("324892013-", getAttribute(f.getTxtPass()));
		sendKeys(f.getTxtAge(),"27");
		Assert.assertEquals("27", getAttribute(f.getTxtAge()));
		click(f.getRadioSex());
		Assert.assertEquals("male", getText(f.getRadioSex()));
		click(f.getBtnSignUp());
		Thread.sleep(5000);
		Assert.assertEquals("https://www.facebook.com/", getCurrentUrl());
	}
	@After
	public void afDateTime() {
		System.out.println("end time"+new Date());
	}
	@AfterClass
	public static void qu() {
		quit();
	}

}
