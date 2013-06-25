
/**
 * Class for Stock objects.
 * 
 * @author jeffreymeyerson
 *
 */

public class Stock {
	
	private String ticker;
	private String companyName;
	private AttributeMap attributes;

	public Stock(String ticker, String companyName) 
	{
		System.out.println("Creating " + ticker + " " + companyName);
		this.ticker = ticker;
		this.companyName = companyName;
		attributes = new AttributeMap(ticker);
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
		attributes.print();
	}

}
