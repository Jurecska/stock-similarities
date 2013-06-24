import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Constants to be used throughout the system.
 * 
 * @author jeffreymeyerson
 *
 */
public class Constants {
	public static String[] ratioCodes = new String[70];
	private static String[] ratioDefinitions = new String[70];
	public static HashMap<String, String> ratioCodesToDefinitions = new HashMap<String, String>();
		
	public static void initializeCodesAndDefinitions() throws FileNotFoundException
	{
		int i = 0;
		Scanner scan = new Scanner(new File("html_ratios.txt"));
		String line = "";
		while(!line.equals("eof"))
		{
			line = scan.nextLine();
			if(line.startsWith("<td>"))
			{
				ratioCodes[i] = line.substring(4, line.length() - 5);
				line = scan.nextLine();
				ratioDefinitions[i] = line.substring(4, line.length() - 5);
				i++;
			}
		}
		for(i = 0; i < 70; i++)
			System.out.println(ratioCodes[i] + " : " + ratioDefinitions[i]);
	}
}
