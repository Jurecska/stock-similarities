import java.io.FileNotFoundException;

/**
 
 * The Runner class for StockSimilarities.  This class contains the user interface, which can be used to query the system.
 * 
 * @author jeffreymeyerson
 *
 */
public class Runner 
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Constants.initializeCodesAndDefinitions();
		Database.generateDatabase();
		Stock aapl = Database.getStock("AAPL");
		System.out.println(aapl.getCompany());
	}
	
}
