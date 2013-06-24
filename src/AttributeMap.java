import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class AttributeMap {

	// Holds the ratios pulled from the csv
	private HashMap<String, RatioHistory> attributeToRatioHistoryMap;
	
	public AttributeMap(String csvLocation) {
		attributeToRatioHistoryMap = new HashMap<String, RatioHistory>();
		for(int i = 0; i < 70; i++)
			attributeToRatioHistoryMap.put(Constants.ratioCodes[i], new RatioHistory());
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
			String[] attributeValues = content.split(",", 70);
			String date = attributeValues[0];
			System.out.println("Date: " + date);
			for(int i = 1; i < 71; i++)
			{
				RatioHistory temp = attributeToRatioHistoryMap.get(Constants.ratioCodes[i]);
				temp.add(date, new Double(attributeValues[i]));
				System.out.println("printing TEMP!!!");
				temp.print();
				attributeToRatioHistoryMap.put(Constants.ratioCodes[i], temp);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		//TEST: PRINT THE MAP
		for(String key : attributeToRatioHistoryMap.keySet())
		{
			System.out.println("Attribute " + key + ":");
			attributeToRatioHistoryMap.get(key).print();
		}
	}

}
