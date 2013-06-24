import java.util.HashMap;


public class RatioHistory {

	private HashMap<String, Double> historyMap;
	
	public RatioHistory()
	{
		historyMap = new HashMap<String, Double>();
	}
	
	//Enters a ratio for the specified date
	public void add(String date, Double ratio) {
		historyMap.put(date, ratio);
	}
	
	public void print()
	{
		for(String key : historyMap.keySet())
		{	
			if(historyMap.get(key) == null)
				System.out.println("wtf!");
			System.out.println(key + " : " + historyMap.get(key));
		}
	}

}
