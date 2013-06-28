package pojos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;

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
				String statisticName = Constants.attributeAbbreviationsToNames.get(abbreviation);
				if (statisticValue == null)
					break;
				rawAttributes.put(statisticName, statisticValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void printMap() {
		System.out.println("Attributes for " + rawAttributes.get("Symbol "));
		for (String key : rawAttributes.keySet())
			System.out.println(key + " : " + rawAttributes.get(key));
	}

	public Collection<String> keySet() {
		return rawAttributes.keySet();
	}

	public String get(String attributeName) {
		return rawAttributes.get(attributeName);
	}

}
