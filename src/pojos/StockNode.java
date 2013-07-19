package pojos;

import java.util.HashMap;

/**
 * A StockNode object contains a ticker name and a map of tickers -> edges.
 * 
 * @author jeffreymeyerson
 *
 */
public class StockNode implements Comparable{


	public String ticker;
	public HashMap<String, Edge> edges;
	public double sumOfIncomingEdges;
	
	public StockNode(String ticker) {
		this.ticker = ticker;
		edges = new HashMap<String, Edge>();
		sumOfIncomingEdges = 0.0;
	}

	@Override
	public int compareTo(Object o) {
		StockNode n = (StockNode)o;
		return sumOfIncomingEdges - n.sumOfIncomingEdges < 0 ? 1 : -1;
	}
}
