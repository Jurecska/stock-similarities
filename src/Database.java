
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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

	public synchronized static void generateDatabase()
	{
		boolean keepGoing = true;
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

}
