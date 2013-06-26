
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The singleton CSVDatabase for StockSimilarities.  A CSVDatabase pulls the csv data, maps a company to an object,
 * and TODO provides an API for Classifiers to query into.
 * 
 * @author Jeff
 *
 */

public class Database 
{
	
	static HashMap<String, Stock> stockMap = new HashMap<String, Stock>();
	
	/**
	 * Load all stocks into memory
	 */
	public synchronized static void loadAllStocks()
	{
		try 
		{
			Scanner s = new Scanner(new File("companylist.csv"));
			String content = s.nextLine();
			System.out.println(content);
			while(content != null)
			{
				content = s.nextLine();
				parseAndMap(content);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Parse a line of content and put it into the stock map.
	 * 
	 * @param content
	 * @return whether the stock was a new addition to the map
	 */
	private static synchronized void parseAndMap(String companyInfo)
	{
		String[] arr = companyInfo.split(",", 2);
		stockMap.put(arr[0], new Stock(arr[0], arr[1]));
	}
	
	public static Stock getStock(String ticker)
	{
		return stockMap.get(ticker);
	}
	
	/**
	 * Load a single stock into memory.
	 * 
	 * @param ticker
	 * @return whether or not the stock was present in the list.  Should not ever be false.
	 */
	public static boolean load(String ticker) {
		try 
		{
			Scanner s = new Scanner(new File("companylist.csv"));
			String companyInfo = s.nextLine();
			while(!companyInfo.substring(1, 6).contains(ticker) && s.hasNext())
				companyInfo = s.nextLine();  // Scan the csv file until you find the company
			System.out.println(companyInfo); // Print the basic details of the company
			if(companyInfo == "eof")
			{
				System.out.println("Company not found.");
				return false;
			}
			parseAndMap(companyInfo);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}		
	}

	public static void printAttributes(String ticker) {
		if(stockMap.containsKey(ticker))
			System.out.println(ticker + " information is not in memory.");
		else
			stockMap.get(ticker).print();
	}

}
