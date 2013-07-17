package pojos;

import java.util.HashMap;

/**
 * A StockNode object contains a ticker name and a map of tickers -> edges.
 * 
 * @author jeffreymeyerson
 *
 */
public class StockNode {


	public String ticker;
	public HashMap<String, Edge> edges;
	
	public StockNode(String ticker) {
		this.ticker = ticker;
		edges = new HashMap<String, Edge>();
	}
}
