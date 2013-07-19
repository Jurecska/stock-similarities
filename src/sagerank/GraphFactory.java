package sagerank;

import java.util.ArrayList;

import pojos.Edge;
import pojos.Stock;
import pojos.StockNode;

/**
 * A factory for producing SageRank graphs.
 * 
 * @author jeffreymeyerson
 *
 */
public class GraphFactory {

	public static Graph sageRank(ArrayList<Stock> stocks)
	{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		ArrayList<StockNode> nodes = new ArrayList<StockNode>();
		// Make the Edges
		for(int i = 0; i < stocks.size() - 1; i++)
		{
			for(int j = i + 1; j < stocks.size(); j++)
				edges.add(new Edge(stocks.get(i), stocks.get(j)));
		}
		// Make the StockNodes
		for(Stock stock : stocks)
		{
			StockNode node = new StockNode(stock.getTicker());
			for(Edge e : edges)
				if(e.ticker1.equals(node.ticker))
					node.edges.put(e.ticker1, e);
				else if(e.ticker2.equals(node.ticker))
					node.edges.put(e.ticker2, e);
			nodes.add(node);
		}
		return new Graph(nodes);
	}
	
}
