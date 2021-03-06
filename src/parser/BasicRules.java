package parser;


/**
 * An example collection of rules for parsing and standardizing Yahoo Finance
 * text.
 * 
 * @author jeffreymeyerson
 * 
 */
public class BasicRules {

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
			else if (statisticName.equals("Book Value "))
				result = new Double(rawData);
			else if (statisticName.equals("Average Daily Volume "))
				result = new Double(rawData);
			else if (statisticName.equals("Bid Size "))
				result = new Double(rawData);
			else if (statisticName.equals("Ask (Real-time) "))
				result = new Double(rawData);
			else if (statisticName.equals("Bid (Real-time)"))
				result = new Double(rawData);
			else if (statisticName.equals("Bid Size "))
				result = new Double(rawData);
			else if (statisticName.equals("Commission "))
				result = new Double(rawData);
			else if (statisticName.equals("Dividend/Share "))
				result = new Double(rawData);
			else if (statisticName.equals("EPS Estimate Current Year "))
				result = new Double(rawData);
			else if (statisticName.equals("EPS Estimate Next Year "))
				result = new Double(rawData);
			else if (statisticName.equals("EPS Estimate Next Quarter "))
				result = new Double(rawData);
			else if (statisticName.equals("Float Shares "))
				result = new Double(rawData);
			else if (statisticName.equals("Day's Low "))
				result = new Double(rawData);
			else if (statisticName.equals("Day's High "))
				result = new Double(rawData);
			else if (statisticName.equals("EBITDA "))
				result = new Double(rawData);
			else if (statisticName.equals("50-day Moving Average "))
				result = new Double(rawData);
			else if (statisticName.equals("200-day Moving Average "))
				result = new Double(rawData);
			else if (statisticName.equals("Last Trade (Price Only) "))
				result = new Double(rawData);
			else if (statisticName.equals("Last Trade Size "))
				result = new Double(rawData);
			else if (statisticName.equals("Earnings/Share "))
				result = new Double(rawData);
			else if (statisticName.equals("Market Cap (Real-time) "))
				result = new Double(rawData);
			else if (statisticName.equals("Market Capitalization "))
				result = new Double(rawData);
			else if (statisticName.equals("Short Ratio "))
				result = new Double(rawData);
			else if (statisticName.equals("Price/Book "))
				result = new Double(rawData);
			else if (statisticName.equals("Last Trade (Price Only) "))
				result = new Double(rawData);
			else if (statisticName.equals("Last Trade Size "))
				result = new Double(rawData);
			else if (statisticName.equals("Previous Close "))
				result = new Double(rawData);
			else if (statisticName.equals("52-week low "))
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
