import java.io.FileNotFoundException;
import java.util.Scanner;

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
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing)
		{
			printConsoleOptions();
			String input = scan.nextLine();
			if(input.equals("load everything"))
				Database.generateDatabase();
			else if(input.startsWith("load"))
				Database.load(input.substring(5, input.length()));
			else if(input.startsWith("print_attributes"))
				Database.printAttributes(input.substring(17, input.length()));
		}
	}

	private static void printConsoleOptions() {
		System.out.println("Welcome to StockSimilarities.  Here are your options:");
		System.out.println("load <ticker> : loads all information about a stock into memory");
		System.out.println("load_everything : load all companies into memory");
		System.out.println("print_attributes <ticker> : print the attributes of a stock");
		System.out.println("q : quit the system");		
	}
}
