
/**
 * Class for Stock objects.
 * 
 * @author jeffreymeyerson
 *
 */

public class Stock {
	
	private String ticker;
	private String company;
	private String priceCode;
	private boolean active;
	private AttributeMap attributes;

	public Stock(String ticker, String company, String priceCode,
			String csvLocation, boolean active) 
	{
		this.ticker = ticker;
		this.company = company;
		this.priceCode = priceCode;
		this.active = active;
		attributes = new AttributeMap(csvLocation);
	}
	
	public String getTicker() 
	{
		return ticker;
	}

	public String getCompany() 
	{
		return company;
	}

	public String getPriceCode() 
	{
		return priceCode;
	}
	
	public boolean isActive() 
	{
		return active;
	}

}
