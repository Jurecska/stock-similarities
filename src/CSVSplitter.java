import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
			URL url12 = new URL(
					"http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab");
			URLConnection urlConn = url12.openConnection();
			InputStreamReader inStream = new InputStreamReader(
					urlConn.getInputStream());
			BufferedReader buff = new BufferedReader(inStream);
			String content = buff.readLine();
			content = buff.readLine();
			while(content != null)
			{
				System.out.println(content);
				content = buff.readLine();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}

