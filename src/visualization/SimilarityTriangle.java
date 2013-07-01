package visualization;

import java.util.ArrayList;
import java.util.Set;

/**
 * The SimilarityTriangle object
 * 
 * @author jeffreymeyerson
 * 
 */

public class SimilarityTriangle {

	int xy;
	int xz;
	int yz;

	public SimilarityTriangle(ArrayList<Stock> stockNodes) {
		Stock x = stockNodes.get(0);
		Set<String> otherStockNames = x.getSimilarityMap().keySet();
	}

}
