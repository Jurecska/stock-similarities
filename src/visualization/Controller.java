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
			ProcessingExporter.exportTriangle(new SimilarityTriangle(stocks));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
