package visualization;

import java.util.ArrayList;
import java.util.Set;

import pojos.Stock;

/**
 * The SimilarityTriangle object
 * 
 * @author jeffreymeyerson
 * 
 */

public class SimilarityTriangle {

	// Side lengths
	int xy;
	int xz;
	int yz;

	public SimilarityTriangle(ArrayList<Stock> stocks) {
		//assert(stocks.size() == 3);
		Stock x = stocks.get(0);
		Stock y = stocks.get(1);
		Stock z = stocks.get(2);
		xy = (int)(250 / vector.Utilities.cosineSimilarity(x.getVector(), y.getVector()));
		xz = (int)(250 / vector.Utilities.cosineSimilarity(x.getVector(), z.getVector()));
		yz = (int)(250 / vector.Utilities.cosineSimilarity(y.getVector(), z.getVector()));
	}

}
