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
