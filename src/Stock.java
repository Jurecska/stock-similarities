
/**
 * Class for Stock objects.  A Stock has a map of attributes, which can be used to construct attribute vectors.
 * 
 * @author jeffreymeyerson
 *
 */

public class Stock {
	
	private String ticker;
	private String companyName;
	private AttributeMap attributes;
	private AttributeVector attributeVector;

	public Stock(String ticker, String companyName) 
	{
		System.out.println("Creating " + ticker + " " + companyName);
		this.ticker = ticker;
		this.companyName = companyName;
		attributes = new AttributeMap(ticker);
		attributeVector = ParserVectorizer.generateAttributeVector(attributes);
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
		attributes.printMap();
	}

}
