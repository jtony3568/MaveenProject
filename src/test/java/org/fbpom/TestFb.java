package org.fbpom;

import org.base.BaseClass;

public class TestFb extends BaseClass{
    public static void main(String[] args) {
    	
    	try {
    	browserLaunch("chrome");
    	}
    	catch(ExceptionInInitializerError e) {
    		System.out.println("not working");
    	}
    	getUrl("https://www.facebook.com/");
    	
    	implicitWait(30);
    	
    	LoginFb l =new LoginFb();
    	
    	sendKeys(l.getTxtUserName(), "tony");
    	sendKeys(l.getTxtPass(), "y3248324");
    	click(l.getBtnLogin());
    	refresh();
    	sendKeys(l.getTxtUserName(), "jtony");
  }
}