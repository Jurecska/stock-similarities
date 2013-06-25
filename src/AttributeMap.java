import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class AttributeMap {

	// Maps an attribute name to a value
	private HashMap<String, String> map;
	
	public AttributeMap(String ticker) {
		map = new HashMap<String, String>();
		for(String abbreviation : Constants.attributeAbbreviations())
		{
			try 
			{
				URL url = new URL(
						"http://finance.yahoo.com/d/quotes.csv?s=A+" + ticker + "&f=" + abbreviation);
				URLConnection urlConn = url.openConnection();
				InputStreamReader inStream = new InputStreamReader(
						urlConn.getInputStream());
				BufferedReader buff = new BufferedReader(inStream);
				String content = buff.readLine();
				content = buff.readLine();
				System.out.println(Constants.attributeAbbreviationsToNames.get(abbreviation) + ": " + content);
				if(content == null)
					break;
				String[] attributeValues = content.split(",");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
