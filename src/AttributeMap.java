import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class AttributeMap {

	private HashMap<String, Double> ratioMap;
	
	public AttributeMap(String csvLocation) {
		boolean keepGoing = true;
		try {
			URL url12 = new URL(
					"http://www.quandl.com/api/v1/datasets/" + csvLocation + ".csv");
			URLConnection urlConn = url12.openConnection();
			InputStreamReader inStream = new InputStreamReader(
					urlConn.getInputStream());
			BufferedReader buff = new BufferedReader(inStream);
			String content = buff.readLine();
			content = buff.readLine();
			System.out.println(content);
			String[] attributeNames = content.split(",", 70);
			String[] attributeValues = attributeNames[70].split(",", 69);
			for(int i = 0; i < 70; i++)
				ratioMap.put(attributeNames[i], new Double(attributeValues[i]));
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
