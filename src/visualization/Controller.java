package visualization;

import java.util.ArrayList;
import java.util.HashMap;

import pojos.Stock;

/**
 * A singleton class for directing the creation and export of visualizations.
 * 
 * @author jeffreymeyerson
 *
 */
public class Controller {
	
	public static void buildTriangle(ArrayList<Stock> stocks)
	{
		assert(stocks.size() == 3);
		HashMap<String, Double> distances = new HashMap<String, Double>();
		ArrayList<StockNode> stockNodes = new ArrayList<StockNode>();
		StockNode x = 
		for(int i = 0; i < 3; i++)
		{
			
		}
			
		ProcessingExporter.exportTriangle(new SimilarityTriangle(stockNodes), distances);
	}

}
