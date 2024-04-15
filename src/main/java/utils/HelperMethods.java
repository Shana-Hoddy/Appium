package utils;

public class HelperMethods {
	
	public static double getFormattedAmount(String amount) {
		return Double.parseDouble(amount.substring(1)); //remove $
	}

}
