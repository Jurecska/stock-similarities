package sagerank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import pojos.Edge;
import pojos.StockNode;

/**
 * A SageRank Graph consists of StockNodes and Edges.
 * 
 * @author jeffreymeyerson
 *
 */
public class Graph {

	// A map of StockNodes -> the sum of their edge weights
	public HashMap<StockNode, Double> nodesToWeights;
	
	public Graph(ArrayList<StockNode> nodes) 
	{
		nodesToWeights = new HashMap<StockNode, Double>();
		for(StockNode node : nodes)
		{
			Double sum = 0.0;
			for(Edge e : node.edges.values())
				sum += e.similarity;
			nodesToWeights.put(node, sum);
		}
		printRankedImportance();
	}
	
	public void printRankedImportance()
	{
		System.out.println("Ranked Importance:");
		for(Entry<StockNode, Double> e : nodesToWeights.entrySet())
			System.out.println(e.getKey().ticker + " : " + e.getValue());
	}

}
