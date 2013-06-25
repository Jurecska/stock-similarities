import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class AttributeMap {

	// Maps a date to a ratio
	private HashMap<String, RatioHistory> attributeToRatioHistoryMap;
	
	public AttributeMap(String ticker) {
		attributeToRatioHistoryMap = new HashMap<String, RatioHistory>();
		for(int i = 0; i < 70; i++)
			attributeToRatioHistoryMap.put(Constants.ratioCodes[i], new RatioHistory());
		for(String attribute : attributeToRatioHistoryMap.keySet())
		{
			RatioHistory temp = attributeToRatioHistoryMap.get(attribute);
			try 
			{
				URL url = new URL(
						"http://www.quandl.com/api/v1/datasets/OFDP/DMDRN_" + ticker + "_" + attribute + ".csv");
				URLConnection urlConn = url.openConnection();
				Thread.sleep(1000);
				InputStreamReader inStream = new InputStreamReader(
						urlConn.getInputStream());
				BufferedReader buff = new BufferedReader(inStream);
				String content = buff.readLine();
				content = buff.readLine();
				System.out.println(attribute + ":" + content);
				String[] attributeValues = content.split(",");
				temp.add(attributeValues[0], new Double(attributeValues[1]));
				System.out.println("printing TEMP!!!");
				temp.print();
				attributeToRatioHistoryMap.put(attribute, temp);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		//TEST: PRINT THE MAP
		for(String key : attributeToRatioHistoryMap.keySet())
		{
			System.out.println("Attribute " + key + ":");
			attributeToRatioHistoryMap.get(key).print();
		}
	}
	
}
