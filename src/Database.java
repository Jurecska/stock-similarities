
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The singleton Database for StockSimilarities.  A Database pulls the csv data, maps each company to an object,
 * and provides an API for Classifiers to query into.
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
	public synchronized static void generateDatabase()
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
	 * @return
	 */
	private static synchronized boolean parseAndMap(String content)
	{
		String[] arr = content.split(",");
		if(stockMap.containsKey(arr[0]))
			return false;
		stockMap.put(arr[0], new Stock(arr[0], arr[1]));
			return true;
	}
	
	public static Stock getStock(String ticker)
	{
		return stockMap.get(ticker);
	}
	
	/**
	 * Load a single stock into memory.
	 * 
	 * @param ticker
	 */
	public static boolean load(String ticker) {
		try 
		{
			Scanner s = new Scanner(new File("companylist.csv"));
			String content = s.nextLine();
			while(!content.substring(1, 6).contains(ticker) && s.hasNext())
				content = s.nextLine();
			System.out.println(content);
			if(content == null)
				return false;
			parseAndMap(content);
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
