package pojos;

import parser.ParserVectorizer;
import vector.AttributeVector;

/**
 * Class for Stock objects. A Stock has a map of raw, unformatted attributes,
 * which can be formatted to construct attribute vectors.
 * 
 * @author jeffreymeyerson
 * 
 */

public class Stock {

	private String ticker;
	private String companyName;
	private AttributeMap attributeMap;
	private AttributeVector attributeVector;

	public Stock(String ticker, String companyName) {
		System.out.println("Creating " + ticker + " " + companyName + "...");
		this.ticker = ticker;
		this.companyName = companyName;
		attributeMap = new AttributeMap(ticker);
		attributeVector = ParserVectorizer
				.generateAttributeVector(attributeMap);
	}

	public String getTicker() {
		return ticker;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void print() {
		System.out.println("Printing attributes for " + ticker);
		attributeMap.printMap();
	}

	public AttributeVector getVector() {
		return attributeVector;
	}

	public AttributeMap getAttributeMap() {
		return attributeMap;
	}

	/**
	 * Calculates a multiple that will be used to scale the stocks against each
	 * other. It is modular, but market cap seems like a decent place to start.
	 * 
	 * @return
	 */
	public int getSize() {
		if(attributeVector.getValue("Market Cap (Real-time) ") != null)
			return attributeVector.getValue("Market Cap (Real-time) ").intValue();
		if(attributeVector.getValue("Market Capitalization ") != null)
			return attributeVector.getValue("Market Capitalization ").intValue();
		if(attributeVector.getValue("Price/EPS Estimate Current Year ") != null)
			return attributeVector.getValue("Price/EPS Estimate Current Year ").intValue();
		return 100;
	}

}
