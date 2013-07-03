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
	public int xy;
	public int xz;
	public int yz;
	public String xName;
	public String yName;
	public String zName;
	public int xSize;
	public int ySize;
	public int zSize;

	/**
	 * A triangle of stocks with edge lengths proportional to their relative
	 * similarities;
	 * 
	 * @param stocks
	 *            an array of three stocks; the last two stocks in the list
	 *            form the points of the hypotenuse
	 */
	public SimilarityTriangle(ArrayList<Stock> stocks) {
		assert(stocks.size() == 3);
		Stock x = stocks.get(0);
		Stock y = stocks.get(1);
		Stock z = stocks.get(2);
		xSize = x.getSize();
		ySize = y.getSize();
		zSize = z.getSize();
		xName = x.getTicker();
		yName = y.getTicker();
		zName = z.getTicker();
		xy = (int) (250 / vector.Utilities.cosineSimilarity(x.getVector(),
				y.getVector()));
		xz = (int) (250 / vector.Utilities.cosineSimilarity(x.getVector(),
				z.getVector()));
		yz = (int) (250 / vector.Utilities.cosineSimilarity(y.getVector(),
				z.getVector()));
	}

}
