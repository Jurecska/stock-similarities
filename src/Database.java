

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import pojos.Stock;
import vector.AttributeVector;

/**
 * The singleton CSVDatabase for StockSimilarities.  A CSVDatabase pulls the csv data, maps a company to an object,
 * and TODO provides an API for Classifiers to query into.
 * 
 * @author Jeff
 *
 */

public class Database 
{
	
	public static HashMap<String, Stock> stockMap = new HashMap<String, Stock>();
	
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
		String[] arr = companyInfo.split(",", 3);
		Stock stock = new Stock(arr[0].replace("\"", ""), arr[1].replace("\"", ""));
		stockMap.put(stock.getTicker(), stock);
	}
	
	public static Stock getStock(String ticker)
	{
		return stockMap.get(ticker);
	}
	
	/**
	 * Load a stock into memory.  Horrible performance.
	 * 
	 * @param ticker
	 */
	public static void load(final String ticker)
	{
		Runnable run = new Runnable()
		{
			public void run()
			{
				loadHelper(ticker);
			}
		};
		Thread thread = new Thread(run);
		thread.start();
	}
	
	/**
	 * Helper for load.
	 * 
	 * @param ticker
	 * @return whether or not the stock was present in the list.  Should not ever be false.
	 */
	private static boolean loadHelper(String ticker) {
		try 
		{
			Scanner s = new Scanner(new File("companylist.csv"));
			String companyInfo = s.nextLine();
			while(!companyInfo.substring(1, 6).contains(ticker) && s.hasNext())
				companyInfo = s.nextLine();  // Scan the csv file until you find the company
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
		System.out.println("keyset: " + stockMap.keySet() + " parameter: " + ticker);
		if(!stockMap.containsKey(ticker))
			System.out.println(ticker + " information is not in memory.");
		else
			stockMap.get(ticker).getAttributeMap().printMap();
	}

	public static void printVector(String ticker) {
		if(!stockMap.containsKey(ticker))
			System.out.println(ticker + " information is not in memory.");
		else
			stockMap.get(ticker).getVector().print();
	}

	public static double measureSimilarities(String stockName1, String stockName2) {
		AttributeVector v1 = stockMap.get(stockName1).getVector();
		AttributeVector v2 = stockMap.get(stockName2).getVector();
		return vector.Utilities.cosineSimilarity(v1, v2);
	}

	public static void visualizationTriangulation(String[] params) {
		ArrayList<Stock> arr = new ArrayList<Stock>();
		for(int i = 1; i < params.length; i++)
			arr.add(stockMap.get(params[i]));
		visualization.Controller.buildTriangle(arr);
	}

}
