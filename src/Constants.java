import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Constants to be used throughout the system.
 * 
 * @author jeffreymeyerson
 *
 */
public class Constants {

	public static HashMap<String, String> attributeAbbreviationsToNames = new HashMap<String, String>();
		
	public static Collection<String> attributeAbbreviations(){
		return attributeAbbreviationsToNames.keySet();
	}
	
	public static Collection<String> attributeNames(){
		return attributeAbbreviationsToNames.values();
	}
	
	public static void initializeCodesAndDefinitions() throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("html_attributes.txt"));
		String line = "";
		while(!line.equals("eof"))
		{
			line = scan.nextLine();
			if(line.startsWith("<B>"))
			{
				String attributeAbbreviation = line.substring(3, line.indexOf("<", 3));
				String attributeName = line.substring(46, line.indexOf("<", 46));
				attributeAbbreviationsToNames.put(attributeAbbreviation, attributeName);
//				System.out.println(attributeAbbreviation + ":" + attributeName);
				line = scan.nextLine();
			}
		}
	}
}
