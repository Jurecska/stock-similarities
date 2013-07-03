package visualization;

import java.io.FileNotFoundException;
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
		
		try {
			ProcessingExporter.exportTriangle(new SimilarityTriangle(sortBySimilarity(stocks)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TODO refactor this garbage
	private static ArrayList<Stock> sortBySimilarity(ArrayList<Stock> stocks) {
		Stock a = stocks.get(0);
		Stock b = stocks.get(1);
		Stock c = stocks.get(2);
		double ab = 1 / vector.Utilities.cosineSimilarity(a.getVector(), b.getVector());
		double ac = 1 / vector.Utilities.cosineSimilarity(a.getVector(), c.getVector());
		double bc = 1 / vector.Utilities.cosineSimilarity(b.getVector(), c.getVector());
		if(ab > bc)
		{
			if(ab > ac)
			{
				stocks.set(0, c);
				stocks.set(1, a);
				stocks.set(2, b);
			}
			else
			{
				stocks.set(0, b);
				stocks.set(1, a);
				stocks.set(2, c);
			}
		}
		else
		{
			stocks.set(0, a);
			stocks.set(1, b);
			stocks.set(2, c);
		}
		return stocks;
	}

}
