package visualization.SimilarityGraph.generated.preproc;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * The SimilarityGraph class.  SimilarityGraph is generated from SimilarityGraphTemplate via the visualization functions of StockSimilarities.
 * 
 * @author jeffreymeyerson
 *
 */
public class SimilarityGraph extends PApplet {
	PFont f;
public void setup(){ 
	size(600,600); 
	f = createFont("Papyrus", 16, true);
} 
 
public void draw(){
	
	textFont(f);		
	
	int borderMin = 50;
	int borderMax = 500; 
	
	//length of lines (similarity)
	int xy = 267;
	int xz = 263;
	int yz = 321;
	
	// length and width of nodes
	int x = 12;
	int y = 218;
	int z = 10;


	fill(255);
	
	// Pythag
	int i = x / 2 + xz + z / 2;
	int j = borderMin + x / 2 + z / 2;
	int pythagXZ = (int)sqrt(i * i - j * j);
	
	int p1x = borderMin + x/2;
	int p1y = borderMin;
	int p2x = borderMin + x + xy;
	int p2y = borderMin;
	int p3x = borderMin;
	int p3y = borderMin + pythagXZ;
	
	ellipse(borderMin, borderMin, x, x);
	line(p1x, p1y, p2x, p2y);
	ellipse(borderMin + x + xy + y / 2, borderMin, y, y);
	ellipse(borderMin, borderMin + pythagXZ + z / 2, z, z);
	line(p1x, p1y, p3x, p3y);
	line(p2x, p2y, p3x, p3y);
	
	
	fill(0);
	text("MSFT",borderMin,borderMin);
	text("AMZN",borderMin + x / 2 + xy + y,borderMin);
	text("AAPL",borderMin,borderMin + pythagXZ);
	
} 
    static public void main(String args[]) {
        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "SimilarityGraph" });
    }
}