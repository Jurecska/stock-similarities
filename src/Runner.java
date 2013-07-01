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
			if(input.equals("load everything"))
				Database.loadAllStocks();
			else if(input.startsWith("load"))
				Database.load(input.substring(5, input.length()));
			else if(input.startsWith("print_attribute_map"))
				Database.printAttributes(input.split(" ")[1]);
			else if(input.startsWith("print_vector"))
				Database.printVector(input.substring(13, input.length()));
			else if(input.startsWith("measure_similarity"))
				System.out.println(Database.measureSimilarities(input.split(" ")[1], input.split(" ")[2]));
			else if(input.equals("q"))
				keepGoing = false;
			else if(input.equals("visualization"))
			{
				if(Database.stockMap.size() == 0)
					enterVisualizationMode();
				else
					System.out.println("Please load a stock before entering visualization mode.");
			}
			
		}
	}

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
	
	private static void printConsoleOptions() {
		System.out.println("Welcome to StockSimilarities.\nHere are your options:\n");
		System.out.println("load <ticker> : loads all information about a stock into memory");
		System.out.println("load_everything : load all companies into memory (takes awhile)");
		System.out.println("print_vector <ticker> : print the formatted stock vector for a ticker which has been loaded into memory");
		System.out.println("print_attribute_map <ticker> : print all raw attributes of a stock which is in memory");
		System.out.println("measure_similarity <ticker> <ticker> : print the cosine similarity of two vectors");
		System.out.println("visualization : enter visualization mode");
		System.out.println("q : quit the system");		
	}
	
	private static void printVisualizationOptions()
	{
		System.out.println("Visualization options:\n");
		System.out.println("similarity_triangulation <ticker> <ticker> <ticker>: draw similarity triangle");
	}
}

