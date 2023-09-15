package com.ker.task.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;


public class Elements {

	public Logger log = Logger.getLogger(Elements.class);

	public static void TypeText(WebElement element, String data) {
		element.sendKeys(data);
	}


	public static void clearTxtBox(WebElement element) {
		element.clear();
	}



	


	



	


	




	}



