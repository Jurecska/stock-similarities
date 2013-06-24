
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

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
		try {
			URL url12 = new URL(
					"https://s3.amazonaws.com/quandl-static-content/quandl-stock-code-list.csv");
			URLConnection urlConn = url12.openConnection();
			InputStreamReader inStream = new InputStreamReader(
					urlConn.getInputStream());
			BufferedReader buff = new BufferedReader(inStream);
			String content = buff.readLine();
			while (content != null && keepGoing) 
			{
				content = buff.readLine();
				keepGoing = parseAndMap(content);
			}
		} 
		catch (Exception e) 
		{
			System.out.print("Problem grabbing data");
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
		boolean active = arr[4].equals("Active") ? true : false; 
		stockMap.put(arr[0], new Stock(arr[0], arr[1], arr[2], arr[3], active));
			return true;
	}
	
	public static Stock getStock(String ticker)
	{
		return stockMap.get(ticker);
	}

}
