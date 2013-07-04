package pojos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;

/**
 * The AttributeMap class. An AttributeMap stores raw data about a company that
 * has been mined from Yahoo Finance. An AttributeMap exists for each Stock, and
 * serves as a data format between HTML and an AttributeVector
 * 
 * @author jeffreymeyerson
 * 
 */

public class AttributeMap {

	// Maps an attribute name to a value
	private HashMap<String, String> rawAttributes;

	/**
	 * Create a new AttributeMap for this ticker. The AttributeMap is generated
	 * from raw Yahoo finance data, some of which may have missing or poorly
	 * formatted entries, so an AttributeMap needs to be converted to an
	 * AttributeVector before any calculations can be done.
	 * 
	 * @param ticker
	 */
	public AttributeMap(String ticker) {
		rawAttributes = new HashMap<String, String>();
		for (String abbreviation : Constants.attributeAbbreviations()) {
			try {
				URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s=A+"
						+ ticker + "&f=" + abbreviation);
				URLConnection urlConn = url.openConnection();
				InputStreamReader inStream = new InputStreamReader(
						urlConn.getInputStream());
				BufferedReader buff = new BufferedReader(inStream);
				String statisticValue = buff.readLine();
				statisticValue = buff.readLine();
				String statisticName = Constants.attributeAbbreviationsToNames
						.get(abbreviation);
				if (statisticValue == null)
					break;
				rawAttributes.put(statisticName, statisticValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Print the map
	 */
	public void printMap() {
		System.out.println("Attributes for " + rawAttributes.get("Symbol "));
		for (String key : rawAttributes.keySet())
			System.out.println(key + " : " + rawAttributes.get(key));
	}

	/**
	 * Get all attribute names.
	 * 
	 * @return
	 */
	public Collection<String> getAttributeNames() {
		return rawAttributes.keySet();
	}

	/**
	 * Get the unformatted value mapped to by a specific attribute name
	 * 
	 * @param attributeName
	 * @return
	 */
	public String getAttributeValue(String attributeName) {
		return rawAttributes.get(attributeName);
	}

}
