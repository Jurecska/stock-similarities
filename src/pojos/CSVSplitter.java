package pojos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * A class for splitting up csv files quickly. Currently only used for testing.
 * 
 * @author jeffreymeyerson
 * 
 */
public class CSVSplitter {

	public static void main(String[] args)
	{
		try 
		{
			Scanner s = new Scanner(new File("companylist.csv"));
			String content = s.nextLine();
			while(content != null)
			{
				System.out.println(content);
				content = s.nextLine();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}

