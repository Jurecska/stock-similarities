import java.io.FileNotFoundException;
import java.util.Scanner;

import pojos.Constants;

import vector.Utilities;

/**
 
 * The Runner class for StockSimilarities.  This class contains the user interface, which can be used to query the system.
 * 
 * TODO: Fix all the inappropriate Database calls.
 * 
 * @author jeffreymeyerson
 *
 */
public class Runner 
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Constants.initializeCodesAndDefinitions();		
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing)
		{
			printConsoleOptions();
			String input = scan.nextLine();
			if(input.equals("ld_tech"))
				Database.loadTech();
			else if(input.startsWith("ld_all"))
				Database.loadEverything();
			else if(input.startsWith("ld"))
				Database.load(input.substring(5, input.length()));
			else if(input.startsWith("print_atts"))
				Database.printAttributes(input.split(" ")[1]);
			else if(input.startsWith("print_vect"))
				Database.printVector(input.substring(13, input.length()));
			else if(input.startsWith("sim"))
				System.out.println(Database.measureSimilarities(input.split(" ")[1], input.split(" ")[2]));
			else if(input.startsWith("sr"))
				sagerank.GraphFactory.sageRank(Database.getAllStocks());
			else if(input.equals("q"))
				keepGoing = false;
			else if(input.equals("visualization"))
			{
				if(Database.stockMap.size() != 0)
					enterVisualizationMode();
				else
					System.out.println("Please load a stock before entering visualization mode.");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Enters the visualization mode.
	 * TODO: add more stuff to visualize
	 */
	private static void enterVisualizationMode() {
		boolean keepGoing = true;
		Scanner scan = new Scanner(System.in);
		while(keepGoing)
		{
			printVisualizationOptions();
			String input = scan.nextLine();
			if(input.startsWith("similarity_triangulation"))
			{
				String[] params = input.split(" ");
				Database.visualizationTriangulation(params);
			
			}
		}
		
	}
	
	/**
	 * Print the console options
	 */
	private static synchronized void printConsoleOptions() {
		System.out.println("ld <ticker> : loads all information about a stock into memory");
		System.out.println("ld_tech : load {GOOG, AAPL, MSFT, AMZN, EBAY, INTC, QCOM, TSLA, NFLX, FB}");
		System.out.println("all : loads all stocks into memory (takes forever)");
		System.out.println("print_vect <ticker> : print the formatted stock vector for a ticker which has been loaded into memory");
		System.out.println("print_atts <ticker> : print all raw attributes of a stock which is in memory");
		System.out.println("sim <ticker> <ticker> : print the cosine similarity of two vectors");
		System.out.println("vis : enter visualization mode");
		System.out.println("sr : perform SageRank");
		System.out.println("q : quit the system");		
	}
	
	/**
	 * Print the options that are available after entering visualization mode.
	 */
	private static synchronized void printVisualizationOptions()
	{
		System.out.println("Visualization options:\n");
		System.out.println("similarity_triangulation <ticker> <ticker> <ticker>: draw similarity triangle");
	}
}

