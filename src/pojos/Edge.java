package pojos;

/**
 * A weighted, undirected edge between two stocks.
 * 
 * @author jeffreymeyerson
 *
 */
public class Edge {

	public String ticker1;
	public String ticker2;
	public double similarity;

	public Edge(Stock stock1, Stock stock2) {
		ticker1 = stock1.getTicker();
		ticker2 = stock2.getTicker();
		similarity = vector.Utilities.cosineSimilarity(stock1.getVector(), stock2.getVector());
	}
	
}
