package pojos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Constants to be used throughout the system.
 * 
 * @author jeffreymeyerson
 * 
 */
public class Constants {

	// A list of attribute codes to their names
	public static HashMap<String, String> attributeAbbreviationsToNames = new HashMap<String, String>();
	
	// tech
	public static String[] techTickers = {"ERIC", "DWA", "DELL", "CMCSA", "AAPL", "GOOG", "MSFT", "AMZN", "EBAY", "INTC", "QCOM", "TSLA", "NFLX", "BBRY"};
	// pharm
	public static String[] pharmTickers = {"KYTH", "JAZZ", "CEMI", "ENTA", "ENZN", "EPZM", "ESRX", "FURX", "GALE", "GWPH", "IDIX", "IDRA"};
	// finance/banking
	public static String[] financeTickers = {"ETFC", "IMCB", "IBCA", "MBTF", "MCBK", "METR"};
	// food/beverage/restaurant
	public static String[] foodTickers = {"KRFT", "COKE",  "JVA", "JACK", "DENN", "DMND",  "DLTR", "FFEX", "GMCR"};

	public static Collection<String> attributeAbbreviations() {
		return attributeAbbreviationsToNames.keySet();
	}

	public static Collection<String> attributeNames() {
		return attributeAbbreviationsToNames.values();
	}

	/**
	 * Load all the constants into memory. This parses Yahoo Finance HTML and
	 * maps the code for a statistic to that statistic's name. That code can be
	 * used to query Yahoo finance for the statistic given by the statistic's
	 * name.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void initializeCodesAndDefinitions()
			throws FileNotFoundException {
		Scanner scan = new Scanner(new File("html_attributes.txt"));
		String line = "";
		while (!line.equals("eof")) {
			line = scan.nextLine();
			if (line.startsWith("<B>")) {
				String attributeAbbreviation = line.substring(3,
						line.indexOf("<", 3));
				String attributeName = line
						.substring(46, line.indexOf("<", 46));
				attributeAbbreviationsToNames.put(attributeAbbreviation,
						attributeName);
				// System.out.println(attributeAbbreviation + ":" +
				// attributeName);
				line = scan.nextLine();
			}
		}
	}
}
