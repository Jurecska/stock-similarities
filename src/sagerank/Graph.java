package sagerank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import pojos.Edge;
import pojos.StockNode;

/**
 * A SageRank Graph consists of StockNodes and Edges.
 * 
 * @author jeffreymeyerson
 *
 */
public class Graph {

	private Set<StockNode> nodes;
	
	public Graph(ArrayList<StockNode> nodesList) 
	{
		nodes = new HashSet<StockNode>(nodesList);
		printRankedImportance();
	}
	
	public void printRankedImportance()
	{
		System.out.println("Ranked Importance:");
		ArrayList<StockNode> nodeList = new ArrayList<StockNode>(nodes);
		Collections.sort(nodeList);
		for(int i = 0; i < nodeList.size(); i++)
			System.out.println(nodeList.get(i).ticker + " : " + nodeList.get(i).sumOfIncomingEdges);
	}

}
