package parser;
/**
 * A more restricted set of rules that attempts to limit the measured metrics to the most important features of a stock.
 * @author jeffreymeyerson
 *
 */
public class RestrictedRules {
	
	
	/**
	 * Converts a line of raw text to a standardized double.
	 * 
	 * TODO Improve this, possibly with erlang pattern matching
	 * 
	 * @param raw
	 * @return
	 */
	public static double convertRaw(String statisticName, String rawData)
			throws NumberFormatException {
		Double result = 0.0;
		try {
			//TODO: Not 98% sure you can use negative numbers in CosSim, but if not then some of these could mess things up
			if (statisticName.equals("Price/EPS Estimate Current Year "))
				result = new Double(rawData);
			else if (statisticName.equals("Average Daily Volume "))
				result = new Double(rawData);
			else if (statisticName.equals("EPS Estimate Current Year "))
				result = new Double(rawData);
			else if (statisticName.equals("EPS Estimate Next Quarter "))
				result = new Double(rawData);
			else if (statisticName.equals("Float Shares "))
				result = new Double(rawData);
			else if (statisticName.equals("Earnings/Share "))
				result = new Double(rawData);
			else if (statisticName.equals("Market Capitalization "))
				result = new Double(rawData);
			else if (statisticName.equals("Short Ratio "))
				result = new Double(rawData);
			else if (statisticName.equals("Price/Book "))
				result = new Double(rawData);
			else if (statisticName.equals("Change in Percent "))
				result = new Double(rawData.substring(1, rawData.indexOf('%')));
			else if (statisticName.equals("Change From 52-week Low "))
				result = new Double(rawData);
			else if (statisticName.equals("Percent Change From 50-day Moving Average "))
				result = new Double(rawData.substring(1, rawData.indexOf('%')));
			else if (statisticName.equals("Percent Change From 52-week High "))
				result = new Double(rawData.substring(1, rawData.indexOf('%')));
			else if (statisticName.equals("Percent Change From 200-day Moving Average "))
				result = new Double(rawData.substring(1, rawData.indexOf('%')));
		} catch (NumberFormatException e) {
			System.out.println("Error parsing " + statisticName
					+ ", cannot convert " + rawData + "to double");
		}
		return result;
	}
}
