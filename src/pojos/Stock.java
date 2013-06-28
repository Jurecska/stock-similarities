package pojos;
import parser.ParserVectorizer;
import vector.AttributeVector;


/**
 * Class for Stock objects.  A Stock has a map of raw, unformatted attributes, which can be formatted to construct attribute vectors.
 * 
 * @author jeffreymeyerson
 *
 */

public class Stock {
	
	private String ticker;
	private String companyName;
	private AttributeMap attributeMap;
	private AttributeVector attributeVector;

	public Stock(String ticker, String companyName) 
	{
		System.out.println("Creating " + ticker + " " + companyName + "...");
		this.ticker = ticker;
		this.companyName = companyName;
		attributeMap = new AttributeMap(ticker);
		attributeVector = ParserVectorizer.generateAttributeVector(attributeMap);
	}
	
	public String getTicker() 
	{
		return ticker;
	}

	public String getCompanyName() 
	{
		return companyName;
	}
	
	public void print()
	{
		System.out.println("Printing attributes for " + ticker);
		attributeMap.printMap();
	}

	public AttributeVector getVector() {
		return attributeVector;
	}

	public AttributeMap getAttributeMap() {
		return attributeMap;
	}

}
