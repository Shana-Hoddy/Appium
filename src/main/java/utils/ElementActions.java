package utils;

import org.openqa.selenium.By;

public interface ElementActions {	
		
	public void longPressAction(By by);
	
	public void scrollToEndAction();
	
	public void scrollToText(String textToScrollTo);
	
	public void swipeAction(By by, String direction);
	
	public void dragAndDropAction(By by, int x, int y);
	
	//can add default actions if shared by both android and ios
}
